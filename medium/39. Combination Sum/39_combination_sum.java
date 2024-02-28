class Solution {

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getTargetCombination(candidates, 0, target, new ArrayList<Integer>());
        return resultList;
    }

    private void getTargetCombination(int[] candidates, int position, int currentTarget, List<Integer> result) {
        if (currentTarget == 0) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        if (position == candidates.length) {
            return;
        }
        if (candidates[position] <= currentTarget) {
            result.add(candidates[position]);
            getTargetCombination(candidates, position, currentTarget - candidates[position], result);
            result.remove(result.size() - 1);
        }
        getTargetCombination(candidates, position + 1, currentTarget, result);
    }
}

//another solution

class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(0, candidates, new ArrayList<>(), list, target);
        return list;
    }
    
    private void helper(int x, int nums[], List<Integer> temp, List<List<Integer>> list, int target) {
        if (target < 0 ) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = x; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(i, nums, temp, list, target - nums[i]);
            temp.remove(temp.size() - 1);          
        }
    }
}





