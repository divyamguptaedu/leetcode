class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int[][] leftArray = new int[n][m];
        int[][] rightArray = new int[n][m];

        int leftResult = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = grid[i][j] % mod;
                leftArray[i][j] = leftResult;
                leftResult = (leftResult * grid[i][j]) % mod;
            }
        }

        int rightResult = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                rightArray[i][j] = rightResult;
                rightResult = (rightResult * grid[i][j]) % mod;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = (leftArray[i][j] * rightArray[i][j]) % mod ;
            }
        }

        return grid;
    }
}