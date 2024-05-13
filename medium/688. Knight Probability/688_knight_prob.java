class Solution {
    int[] dir1 = { -2, -1, 1, 2, 2, 1, -1, -2 };
    int[] dir2 = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public double knightProbability(int n, int k, int row, int col) {
        if (k == 0) {
            return 1.0;
        }
        double[][][] dp = new double[30][30][101];

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                for (int l = 0; l < 101; l++) {
                    dp[i][j][l] = 0.0;
                }
            }
        }

        return solve(n, k, row, col, dp);
    }

    public boolean isValid(int i, int j, int n) {
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return false;
        }

        return true;
    }

    public double solve(int n, int k, int i, int j, double[][][] dp) {
        if (k <= 0) {
            return 1;
        }

        if (i < 0 || j < 0 || i >= n || j >= n) {
            return 0.0;
        }

        if (dp[i][j][k] != 0.0) {
            return dp[i][j][k];
        }

        double res = 0.0;
        double num = 1.0;
        double denom = 8.0;
        for (int l = 0; l < 8; l++) {
            int x = i + dir1[l];
            int y = j + dir2[l];
            if (isValid(x, y, n)) {
                res += solve(n, k - 1, x, y, dp) * (num / denom);
            }
        }

        return dp[i][j][k] = res;
    }
}