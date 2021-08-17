"""
Performance: 
Runtime: 3 ms, faster than 99.93% of Java online submissions for Design Tic-Tac-Toe.
Memory Usage: 41.9 MB, less than 68.95% of Java online submissions for Design Tic-Tac-Toe.
"""

class TicTacToe {
    int[] rows, cols;
    int diagonal, anti_diagonal, target;
    /** Initialize your data structure here. */

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        anti_diagonal = 0;
        target = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int sign = player == 1 ? 1 : -1, res = sign * target;
        rows[row] += sign;
        cols[col] += sign;
        if(row == col) diagonal += sign;
        if(row == target-1-col) anti_diagonal += sign;
        if(rows[row] == res || cols[col] == res || diagonal == res || anti_diagonal == res) return player;
        else return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */