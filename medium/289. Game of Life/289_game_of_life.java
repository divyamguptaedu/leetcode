"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
Memory Usage: 40.6 MB, less than 86.36% of Java online submissions for Game of Life.
"""

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int sides = helper(i, j, board);
                if (board[i][j] == 1 && sides < 2) 
                    result[i][j] = 0;
                if (board[i][j] == 1 && ((sides == 2) || sides == 3))
                    result[i][j] = 1;
                if (board[i][j] == 1 && sides > 3) 
                    result[i][j] = 0;
                if (board[i][j] == 0 && sides == 3) 
                    result[i][j] = 1;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }
    
    private int helper(int i, int j, int[][] board) {
        int result = 0;
        int[][] temp = {{0,-1},{0,1},{1,0},{1,-1},{1,1},{-1,-1},{-1,1},{-1,0}};
        for (int[] t : temp) {   
            int x = i + t[0];
            int y = j + t[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length)
                result += board[x][y];
         }
         return result;
    }
}