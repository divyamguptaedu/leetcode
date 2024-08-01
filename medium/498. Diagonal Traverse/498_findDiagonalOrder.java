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

//

class Solution {
    int rows;
    int cols;
    int[] result;
    int[][] mat;
    boolean reverse;
    int index;
    public int[] findDiagonalOrder(int[][] mat) {
        this.index = 0;
        this.mat = mat;
        this.rows = mat.length;
        this.cols = mat[0].length;
        this.result = new int[rows * cols];
        ArrayList<Integer> temp;
        int row = 0;
        this.reverse = true;
        for (int col = 0; col < cols; col++) {  
            temp = new ArrayList<>();
            getDiagonalList(row, col, temp);
            reverse = !reverse;
        }
        int col_ = cols - 1;
        for (int row_ = 1; row_ < rows; row_++) {
            temp = new ArrayList<>();
            getDiagonalList(row_, col_, temp);
            reverse = !reverse;
        }
        return result;
    }

    private void getDiagonalList(int row, int col, ArrayList<Integer> temp) {
        while (isValidMove(row, col)) {
            temp.add(mat[row][col]);
            row++;
            col--;
        }
        if (this.reverse) {
            Collections.reverse(temp);
        }
        for (int i : temp) {
            result[index++] = i;
        }
    }

    private boolean isValidMove(int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            return true;
        }
        return false;
    }
}