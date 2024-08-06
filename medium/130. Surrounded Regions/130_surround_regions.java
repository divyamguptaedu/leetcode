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

//another solution

class Solution {
    Integer rows = 0;
    Integer cols = 0;
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        this.rows = board.length;
        this.cols = board[0].length;
        List<Pair<Integer, Integer>> borders = new LinkedList<Pair<Integer, Integer>>();
        for (int r = 0; r < this.rows; ++r) {
            borders.add(new Pair(r, 0));
            borders.add(new Pair(r, this.cols - 1));
        }
        for (int c = 0; c < this.cols; ++c) {
            borders.add(new Pair(0, c));
            borders.add(new Pair(this.rows - 1, c));
        }
        for (Pair<Integer, Integer> pair : borders) {
            if (board[pair.getKey()][pair.getValue()] == 'O') {
                this.dfs(board, pair.getKey(), pair.getValue());
            }
        }
        for (int r = 0; r < this.rows; ++r) {
            for (int c = 0; c < this.cols; ++c) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'E') board[r][c] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        board[row][col] = 'E';
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValidMove(newRow, newCol) && board[newRow][newCol] == 'O') {
                dfs(board, newRow, newCol);
            }
        }
    }

    private boolean isValidMove(int i, int j) {
        return (i >= 0 && i < rows && j >= 0 && j < cols);
    }


}