class Solution {
    public int maxProductPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        long[][][] dp = new long[rows][cols][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];

        for (int j = 1; j < cols; j++) {
            dp[0][j][0] = grid[0][j] * dp[0][j - 1][0];
            dp[0][j][1] = grid[0][j] * dp[0][j - 1][1];
        }

        for (int i = 1; i < rows; i++) {
            dp[i][0][0] = grid[i][0] * dp[i - 1][0][0];
            dp[i][0][1] = grid[i][0] * dp[i - 1][0][1];
        }

        long min;
        long max;
        long currentValue;
        long multipliedValue;
        long[] top;
        long[] left;

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                top = dp[i-1][j];
                left = dp[i][j-1];
                currentValue = grid[i][j];

                multipliedValue = top[0] * currentValue;
                max = Math.max(max, multipliedValue);
                min = Math.min(min, multipliedValue);

                multipliedValue = top[1] * currentValue;
                max = Math.max(max, multipliedValue);
                min = Math.min(min, multipliedValue);

                multipliedValue = left[0] * currentValue;
                max = Math.max(max, multipliedValue);
                min = Math.min(min, multipliedValue);

                multipliedValue = left[1] * currentValue;
                max = Math.max(max, multipliedValue);
                min = Math.min(min, multipliedValue);

                dp[i][j][0] = min;
                dp[i][j][1] = max;
            }
        }

        if (dp[rows - 1][cols - 1][1] >= 0) {
            return (int) ((dp[rows - 1][cols - 1][1]) % (int) (1e9 + 7));
        } else {
            return -1;
        }

    }
}