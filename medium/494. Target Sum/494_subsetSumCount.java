class Solution {
    public int subsetSumCount(int[] nums, int sum) {
        int[][] dp = new int[nums.length + 1][sum + 1];
        // Initialization
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        // Core logic
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }

    public int findTargetSumWays(int[] nums, int target) {
        // Step1: Divide nums in 2 subsets having sum s1 and s2
        // Step2: Find all the combinations such that s2-s1=target
        // Step3: Find sum of the array = Range
        // Step4: All the subset sum will fall between [0, Range]
        // Step5: s2+s1=Range
        // Step6: step2+step5 = 2*s2=Range+target -> s2=(Range+target)/2
        // Step7: Find subset s2 having sum=(Range+target)/2

        int Range = 0;
        for (int num : nums) {
            Range += num;
        }
        if (Math.abs(target) > Range || (Range - target) % 2 != 0) {
            return 0;
        }
        // Find the count of subsets for given sum
        int s2 = (Range + target) / 2;
        return subsetSumCount(nums, s2);
    }
}