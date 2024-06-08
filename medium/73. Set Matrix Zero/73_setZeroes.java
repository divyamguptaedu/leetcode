//I first identify if the first column needs to be set to zero using a boolean variable.
//Then, I iterate through the matrix, marking the corresponding first row and column elements
//as zero if the current element is zero.
//In a second pass, I update the elements based on the first row and column markers.
//Finally, I handle setting the entire first row and column to zero if necessary based on
//the boolean variable.

//Time: mn
//Space: constant
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstColZero = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Mark the first column zero flag if necessary
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZero = true;
            }

            // Mark corresponding first row and column zero
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Update matrix based on first row and column markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set first row to zero if necessary
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Set first column to zero if necessary
        if (isFirstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}