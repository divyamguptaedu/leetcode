class Solution {
    public int minimumOperations(List<Integer> nums) {
        int[] groups = new int[4];

        for (int num : nums) {
            groups[num] += 1;
            groups[2] = Math.max(groups[1], groups[2]);
            groups[3] = Math.max(groups[3], groups[2]);
        }

        return nums.size() - groups[3];
    }
}