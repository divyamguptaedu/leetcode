//To check if a 9x9 Sudoku board is valid, 
//I used three arrays to track the presence of numbers in rows, 
//columns, and 3x3 sub-boxes. For each cell, 
//I skipped empty cells and calculated a bit position for the current digit. 
//I checked if the bit was already set in the respective row, column, or sub-box. 
//If any bit was already set, the board was invalid. 
//If not, I set the bit in the corresponding row, column, and sub-box. 
//This ensured no duplicates in rows, columns, or sub-boxes.

//Time: n^2
//Space" n
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use a binary number to record previous occurrence
        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] boxes = new int[N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // Check if the position is filled with number
                if (board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] - '0';
                int pos = 1 << (val - 1); //Calculate the bit position pos for this digit using bitwise shift: 1 << (val - 1).

                // Check the row
                if ((rows[r] & pos) > 0) { //Use a bitwise AND operation to check if pos is already set in the current row (rows[r]).
                    return false;
                }
                rows[r] |= pos; //If not, set the bit in rows[r] using a bitwise OR operation.

                // Check the column
                if ((cols[c] & pos) > 0) {
                    return false;
                }
                cols[c] |= pos;

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if ((boxes[idx] & pos) > 0) {
                    return false;
                }
                boxes[idx] |= pos;
            }
        }
        return true;
    }
}