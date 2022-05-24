"""
Performance:
Runtime: 3 ms, faster than 80.46% of Java online submissions for Valid Sudoku.
Memory Usage: 45.5 MB, less than 69.01% of Java online submissions for Valid Sudoku.
"""

class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] section = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int k = board[i][j] - '0'; 
                if (row[i][k] || col[j][k]) {
                    return false;  
                }
                int g = 3 * (i / 3) + j / 3;
                if (section[g][k]) {
                    return false;
                }
                row[i][k] = col[j][k] = section[g][k] = true;
            }
        }
        return true;
    }
}