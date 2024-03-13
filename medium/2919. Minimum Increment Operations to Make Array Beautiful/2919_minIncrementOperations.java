class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int length = nums.length;
        long result = Long.MAX_VALUE;
        long[] incrementCounts = new long[length];
        incrementCounts[0] = Math.max(0, k - nums[0]);
        incrementCounts[1] = Math.max(0, k - nums[1]);
        incrementCounts[2] = Math.max(0, k - nums[2]);
        for (int i = 3; i < length; i++) {
            incrementCounts[i] = Math.max(0, k - nums[i]) + Math.min(Math.min(incrementCounts[i - 3], incrementCounts[i - 2]), incrementCounts[i - 1]);
        }
        return Math.min(Math.min(incrementCounts[length - 3], incrementCounts[length - 2]), incrementCounts[length - 1]);
    }
}
