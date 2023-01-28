class Solution {
    public int maxTurbulenceSize(int[] nums) {
        int len = nums.length, max = 1;
        int[][] dp = new int[len][2];
        for (int i = 1; i < len; i++) {
            dp[i][0] = 1;
            if (nums[i] > nums[i - 1]) {
                if (dp[i - 1][1] == -1) {
                    dp[i][0] = 1 + dp[i - 1][0];
                    dp[i][1] = 1; 
                } else {
                    dp[i][0] = 2;
                    dp[i][1] = 1;
                } 
            } else if (nums[i] < nums[i - 1]) {
                if (dp[i - 1][1] == 1) {
                    dp[i][0] = 1 + dp[i - 1][0];
                    dp[i][1] = -1;
                } else {
                    dp[i][0] = 2;
                    dp[i][1] = -1;
                }
            }
            max = Math.max(dp[i][0], max);
        }
        return max;
    }
}