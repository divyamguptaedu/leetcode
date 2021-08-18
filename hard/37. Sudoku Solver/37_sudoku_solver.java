"
Performance:
Runtime: 16 ms, faster than 40.05% of Java online submissions for Sudoku Solver.
Memory Usage: 36.2 MB, less than 94.23% of Java online submissions for Sudoku Solver.
"

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0;i < board.length; i++) { // start traversing from row 0 to 8
            for (int j = 0;j < board.length; j++) { // Now check for every col in each row
                if (board[i][j] == '.') {  // If '.' is in that row col then it shows it is empty
                    for (char c = '1'; c <= '9'; c++) { // Now we will try to fill from 1 to 9
                        if (isValid(board, i, j, c)) { //this function will return true if the corresponding ch is not in row,col,nor in 3x3 matrix
                            board[i][j] = c; // if it returns true then we will add c to board
                            if (solve(board)) { // Now we will further recurse for next empty space
                                return true;  // if this function return true it means that board is completely filled 
                            } else{ // it shows that the c we filled is a deadend and we have to backtrack
                                board[i][j] = '.'; //so we remove that ch
                            }
                        }
                    }
                    return false;  // if it does return true for any ch 1 to 9 then it means we are in a deadend and we will return false
                }
            }
        } //finally we will return true as we completely filled the matrix
        return true;
    }
    
	// to check if the corresponding character is valid or not which means the charcater is not in the corresponding row or column or 3x3 matrix
	// we will check this in only one loop by using 3 formulaes
	// for row we will keep row constant and change col from 0 to 8 and check if the corresponding character is present or not
	// for col we will keep col constant and change row from 0 to 8 and check if the corresponding character is present or not
	// for 3x3 matrix for row it will be 3*(row/3) + i/3
	// for col = 3*(col/3) + i%3
	// board[row][col]=c return false
	// below code will help you understand this
	
	
    public boolean isValid(char board[][], int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) {
                return false;
            }
            if (board[i][col] == ch) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }
}