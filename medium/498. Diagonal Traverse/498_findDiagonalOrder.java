//I checked for an empty matrix and initialized variables for matrix dimensions, 
//current row and column, direction, and result array. 
//I iterated through the matrix elements, adding the current element to the result array and 
//calculating the next row and column based on the current direction. 
//If the next element was out of bounds, I adjusted the row and column to the next valid position and 
//flipped the direction. I continued this process until all elements were traversed.

//Time: O(mn)
//Space: O(1)

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // Indices that will help us progress through the matrix
        int row = 0, column = 0;

        // Variable to keep track of the current direction
        int direction = 1;

        // The final result array
        int[] result = new int[N * M];
        int r = 0;

        // Iterate over all the elements in the array
        while (row < N && column < M) {
            // Add the current element to the result array
            result[r++] = matrix[row][column];

            // Move along the current diagonal depending on the direction
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            // Check if the next element in the diagonal is within bounds
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {
                // If the current diagonal was going upwards
                if (direction == 1) {
                    // For an upwards diagonal, find the next head
                    row += (column == M - 1 ? 1 : 0);
                    column += (column < M - 1 ? 1 : 0);
                } else {
                    // For a downwards diagonal, find the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }
                // Flip the direction
                direction = 1 - direction;
            } else {
                // Move to the next element in the diagonal
                row = new_row;
                column = new_column;
            }
        }
        return result;
    }
}