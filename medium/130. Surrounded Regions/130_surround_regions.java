/*
Runtime: 1 ms, faster than 99.64% of Java online submissions for Surrounded Regions.
Memory Usage: 41.4 MB, less than 33.10% of Java online submissions for Surrounded Regions.
*/

class Solution {
    public void solve(char[][] board) {
        int left = 0;
        int right = board[0].length - 1;
        int top = 0;
        int bottom = board.length - 1; 
        
        for (int i = left; i <= right; i++) {
            markBoundryRegions(board, top, i);
        }
        
        for (int i = top; i <= bottom; i++) {
            markBoundryRegions(board, i, right);
        }
        
        for (int i = right; i >= left; i--) {
            markBoundryRegions(board, bottom, i);
        }
        
        for (int i = bottom; i >= top; i--) {
            markBoundryRegions(board, i, left);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    private void markBoundryRegions(char[][] board, int row, int col) {
        
        if (row < 0 || row >= board.length 
            || col < 0 || col >= board[0].length 
            || board[row][col] == 'X' || board[row][col] == '1') {
            return;
        }
        
        board[row][col] = '1';
        markBoundryRegions(board, row, col + 1);
        markBoundryRegions(board, row, col - 1);
        markBoundryRegions(board, row + 1, col);
        markBoundryRegions(board, row - 1, col);
    }
}