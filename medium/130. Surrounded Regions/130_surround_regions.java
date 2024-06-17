//Recursive DFS approach
//I identified all 'O's on the borders of the matrix and marked them as non-surrounded by replacing 
//them with 'Y'. I then checked all adjacent cells recursively to ensure all connected 'O's are also 
//marked. Finally, I traversed the entire board to convert the remaining 'O's to 'X's (since they are 
//surrounded) and reverted the 'Y's back to 'O's.

//Time: n
//Space: n
class Solution {
    int rows, cols;

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        // Mark all 'O's on the borders and connected to borders with 'Y'
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == rows - 1 || j == cols - 1)) {
                    markBorderConnected(board, i, j);
                }
            }
        }

        // Convert remaining 'O's to 'X' and 'Y's back to 'O'
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void markBorderConnected(char[][] board, int x, int y) {
        board[x][y] = 'Y';
        if (x < rows - 1 && board[x + 1][y] == 'O') {
            markBorderConnected(board, x + 1, y);
        }
        if (y < cols - 1 && board[x][y + 1] == 'O') {
            markBorderConnected(board, x, y + 1);
        }
        if (x > 0 && board[x - 1][y] == 'O') {
            markBorderConnected(board, x - 1, y);
        }
        if (y > 0 && board[x][y - 1] == 'O') {
            markBorderConnected(board, x, y - 1);
        }
    }
}