//I solved the N-Queens problem by recursively placing queens on the chessboard, ensuring no two queens attack each other. 
//I implemented a backtracking algorithm where I place a queen in each column and recursively explore valid placements 
//in subsequent columns. I checked the validity of each placement by verifying no other queen 
//is present on the same row, column, or diagonal. 
//Once a valid configuration is found, I add it to the result list. 
//I represented the chessboard as a 2D char array and constructed the solution format accordingly.

//Time: O(n!) where n is the size of the chessboard. 
//This is because the algorithm explores all possible configurations of queen placements, considering all permutations.
//Space: O(n^2)
class Solution {
    // Main function to solve N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with empty cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Start placing queens from the first column
        placeQueens(0, ans, board, n);
        return ans;
    }

    // Recursive function to place queens on the board
    public void placeQueens(int col, List<List<String>> ans, char[][] board, int n) {
        if (col == n) {
            ans.add(construct(board));
            return;
        }

        // Check for all rows of the current column
        for (int i = 0; i < n; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q'; // Place queen
                placeQueens(col + 1, ans, board, n); // Recur for next column
                board[i][col] = '.'; // Backtrack
            }
        }
    }

    // Function to construct the solution format
    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    // Function to check if placing a queen at position (row, col) is valid
    public boolean isValid(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        int n = board.length;
        
        // Check upper diagonal
        while (duprow >= 0 && dupcol >= 0) {
            if (board[duprow][dupcol] == 'Q')
                return false;
            duprow--;
            dupcol--;
        }

        // Check left row
        duprow = row;
        dupcol = col;
        while (dupcol >= 0) {
            if (board[duprow][dupcol] == 'Q')
                return false;
            dupcol--;
        }

        // Check lower diagonal
        duprow = row;
        dupcol = col;
        while (duprow < n && dupcol >= 0) {
            if (board[duprow][dupcol] == 'Q')
                return false;
            duprow++;
            dupcol--;
        }

        return true;
    }
}