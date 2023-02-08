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






