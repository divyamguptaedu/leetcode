class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int index = 0;
        Arrays.sort(candidates);
        helper(result, candidates, target, tempList, index);
        return result;
    }

    private void helper(List<List<Integer>> result, int[] candidates, int target, List<Integer> current, int index) {
    	if (target > 0) {
    		for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
    			current.add(candidates[i]);
    			helper(result, candidates, target - candidates[i], current, i);
    			current.remove(current.size() - 1);
    		}
    	} else {
    		if (target == 0) {
    			result.add(new ArrayList<Integer>(current));
    		}
    	}
    }
}