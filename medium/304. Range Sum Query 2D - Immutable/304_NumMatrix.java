class NumMatrix {
    private int[][] prefixSumMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        prefixSumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                prefixSumMatrix[r + 1][c + 1] = prefixSumMatrix[r + 1][c] + prefixSumMatrix[r][c + 1] - prefixSumMatrix[r][c] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int[][] dp = prefixSumMatrix;
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}