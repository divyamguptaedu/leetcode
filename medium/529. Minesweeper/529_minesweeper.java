//Created a directions array to make it easy to get the adjacent cells. 
//Then checked if we clicked on a mine, if yes, then changed it to X and returned board. 
//If not, then fired a helper function which reveals the board. 
//In the helper function, first checked if the cell is valid and is not already explored. 
//Then get the total mine count in the adjacent cells, change that cell to represent the mine count, 
//and recurse helper function on its adjacent cells.

//Time Complexity: O(8 * M * N) = O(M * N)
//Space Complexity: O(M * N)

class Solution {
    private static final int[][] directions = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 },  { -1, 1 } };

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        revealBoard(board, click[0], click[1]);
        return board;
    }

    private void revealBoard(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
            return;
        }
        int mines = getMinesCount(board, x, y);
        if (mines != 0) {
            board[x][y] = (char) (mines + '0');
            return;
        }
        board[x][y] = 'B';
        for (int[] d : directions) {
            revealBoard(board, x + d[0], y + d[1]);
        }
    }

    private int getMinesCount(char[][] board, int x, int y) {
        int mines = 0;
        for (int[] d : directions) {
            int r = x + d[0];
            int c = y + d[1];
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'M') {
                mines++;
            }
        }
        return mines;
    }
}