class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int dp[][][] = new int[n + 1][4][2];
        int prefix[] = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] += prefix[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 4; j++) {
                if (i < j * k) {
                    continue;
                } else {
                    if (dp[i - k][j - 1][0] + prefix[i] - prefix[i - k] > dp[i - 1][j][0]) {
                        dp[i][j][0] = dp[i - k][j - 1][0] + prefix[i] - prefix[i - k];
                        dp[i][j][1] = i - k;
                    } else {
                        dp[i][j][0] = dp[i - 1][j][0];
                        dp[i][j][1] = dp[i - 1][j][1];
                    }
                }
            }
        }

        int ans[] = new int[3];
        int last = n;
        for (int i = 2; i >= 0; i--) {
            ans[i] = dp[last][i + 1][1];
            last = ans[i];
        }
        return ans;
    }
}