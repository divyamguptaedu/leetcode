"
Performance:
Runtime: 2323 ms, faster than 5.50% of Java online submissions for Range Sum Query 2D - Immutable.
Memory Usage: 132.6 MB, less than 26.73% of Java online submissions for Range Sum Query 2D - Immutable.
"
class NumMatrix {
    public int[][] table;
    public NumMatrix(int[][] matrix) {
        table = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                result+=table[i][j];
            }
        }
        return result;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */