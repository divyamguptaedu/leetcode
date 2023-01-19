class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i <= nums.length - 3; i++) {
            if ((nums[i + 1] - nums[i]) == (nums[i + 2] - nums[i + 1])) {
                dp[i + 2] = dp[i + 2 - 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum = sum + dp[i];
        }
        return sum;
    }
}