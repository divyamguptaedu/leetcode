class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        int[][] dp = new int[m + 2][n + 2];
        int[][] dpTwo = new int[m + 2][n + 2];

        for (int i = 1; i <= m; i++) {
            dp[i][1]++;
            dp[i][n]++;
        }
        for (int j = 1; j <= n; j++) {
            dp[1][j]++;
            dp[m][j]++;
        }

        int result = dp[startRow + 1][startColumn + 1];
        for (int d = 1; d < maxMove; d++) {
            int[][] x = dp;
            dp = dpTwo;
            dpTwo = x;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = (int)(((long)dpTwo[i - 1][j] + dpTwo[i + 1][j] + dpTwo[i][j - 1] + dpTwo[i][j + 1]) % 1000000007L);
                }
            }
            result = (result + dp[startRow + 1][startColumn + 1]) % 1000000007;
        }
        return result;
    }
}