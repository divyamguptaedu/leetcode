class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int index = 0;

        // sort the candidates;
        Arrays.sort(candidates);

        // use helper function to find combinations;
        helper(result, candidates, target, tempList, index);
        return result;
    }

    private void helper(List<List<Integer>> result, int[] candidates, int target, List<Integer> current, int index) {
    	if (target > 0) {
            // try each combination;
    		for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
    			current.add(candidates[i]);
    			helper(result, candidates, target - candidates[i], current, i);
    			current.remove(current.size() - 1);
    		}
    	} else {
            // base case - if found, add to the result;
    		if (target == 0) {
    			result.add(new ArrayList<Integer>(current));
    		}
    	}
    }
}