class Solution {
    
    int[][] canMove = {{4,6},{6,8},{7,9},{4,8},{0,3,7},{},{0,1,7},{2,6},{1,3},{2,4}};
    int mod = Integer.MAX_VALUE;

    public int knightDialer(int n) {
        int ans = 0;
        Integer[][] dp = new Integer[n + 1][10];
        for(int i = 0; i < 10; i++) {
            ans = (ans % mod + helper(n - 1, i, dp) % mod) % mod;
        }
        return ans;
    }

    public int helper(int n, int curr, Integer[][] dp){
        if (n == 0)
            return 1;
        if (dp[n][curr] != null)
            return dp[n][curr];
        int ans = 0;
        for (int i: canMove[curr]) {
            ans = (ans%mod + helper(n - 1, i, dp) % mod) % mod;
        }
        return dp[n][curr] = ans;
    }
}