//I used an array-based approach to implement a Tic-Tac-Toe game on an n x n board. 
//I tracked the count of each player's marks in rows, columns, and both diagonals. 
//Each player’s move updated these counts, adding 1 for player 1 and -1 for player 2. 
//After each move, I checked if any count reached the absolute value of n, indicating a win. 
//If a win condition was met in any row, column, or diagonal, the player won. 
//Otherwise, the game continued.

//Time: O(1)
//Space: O(n)
class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diag1;
    private int diag2;

    public TicTacToe(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid size");
        }

        rows = new int[n]; // Array to track row counts
        cols = new int[n]; // Array to track column counts
    }

    public int move(int row, int col, int player) {
        int n = rows.length;
        int val = player == 1 ? 1 : -1; // Value for player 1 is 1, for player 2 is -1

        rows[row] += val; // Update row count
        cols[col] += val; // Update column count
        if (row == col) {
            diag1 += val; // Update diagonal1 count if move is on the main diagonal
        }
        if (row + col == n - 1) {
            diag2 += val; // Update diagonal2 count if move is on the anti-diagonal
        }

        // Check if any row, column, or diagonal count reaches n or -n
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag1) == n || Math.abs(diag2) == n) {
            return player;
        }
        return 0; // No winner yet
    }
}