//I explored the N-Queens problem by recursively placing queens on a chessboard, avoiding conflicts. 
//For each row, I iterated over columns, checking if the queen placement conflicts with existing ones diagonally, 
//anti-diagonally, or horizontally. If not, I placed the queen and moved to the next row. 
//Upon reaching the last row, I stored the valid configuration. 
//I utilized backtracking to explore all possible configurations efficiently. 
//By toggling queen placements and utilizing sets to track conflicts, 
//I avoided unnecessary computations. Ultimately, I returned all distinct solutions.

//Time: O(n!)
//Space: O(n^2)

class Solution {
    private int size; // Size of the chessboard
    private List<List<String>> solutions = new ArrayList<List<String>>(); // List to store all distinct solutions

    public List<List<String>> solveNQueens(int n) {
        size = n; // Initialize size of the chessboard
        char emptyBoard[][] = new char[size][size]; // Create an empty chessboard
        // Fill the empty chessboard with dots representing empty spaces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }

        // Start backtracking to find solutions
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions; // Return all distinct solutions
    }

    // Helper function to convert char array representation of board to List of Strings
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        return board;
    }

    // Backtracking function to explore all possible configurations
    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, char[][] state) {
        // Base case - all queens have been placed
        if (row == size) {
            solutions.add(createBoard(state)); // Add the current valid configuration to solutions
            return;
        }

        // Try placing queen in each column of the current row
        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            // Check if queen can be placed in this position without conflicts
            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue; // If conflicts, skip to next column
            }

            // Place the queen and update sets to mark conflicts
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col] = 'Q';

            // Recur for the next row
            backtrack(row + 1, diagonals, antiDiagonals, cols, state);

            // Backtrack - remove the queen and reset the sets
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] = '.';
        }
    }
}