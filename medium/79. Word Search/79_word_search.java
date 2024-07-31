//Did a four way dfs on the grid interating over every cell. 
//In the dfs function, we check for all the bad cases first like the row and col number, 
//and if the char present at that cell is the char at the current index in the word, 
//basically is it the letter we are looking for, if yes, we mark it as visited, 
//and kick off the four way dfs by increasing the index by 1. 
//If not, we set the cell back to its original letter and return false. 
//For the time complexity, in the worst case, we kick off the word at the very last index, 
//so O(N) to reach there where N is the number of cells in the grid, 
//and since at that point we would have already explored one of the directions, 
//we will have three directions left, so O(3^L) where L is the length of the word. 

//Time: O(N.3^L) where N is the #cells and L is the length of the word
//Space: O(L)
class Solution {
    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row) {
            for (int col = 0; col < this.COLS; ++col) {
                if (this.backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS || this.board[row][col] != word.charAt(index)) { //all bad cases
            return false;
        }
        this.board[row][col] = '#'; //mark as visited for the upcoming four way dfs
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            if (this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1)) { //four way dfs
                return true;
            }
        }
        this.board[row][col] = word.charAt(index); //backtrack, set it back to the original
        return false;
    }
}

//implemented again
class Solution {
    char[][] board;
    int rows;
    int cols;
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int row = 0; row < this.rows; ++row) {
            for (int col = 0; col < this.cols; ++col) {
                if (find(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == word.charAt(index)) {
            this.board[row][col] = '#';
            for (int[] dir : dirs) {
                if (find(row + dir[0], col + dir[1], word, index + 1)) {
                    return true;
                }
            }
            this.board[row][col] = word.charAt(index);
        }
        return false;
    }
}