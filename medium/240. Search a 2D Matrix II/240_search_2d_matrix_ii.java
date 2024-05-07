//Because the rows and columns of the matrix are sorted (from left-to-right and top-to-bottom), we can take advantage
//of this and reduce our search space.
//We can start from the bottom left of the matrix and while the row and col values are within range,
//If the value > target, we go to the row above.
//If value < target, we go to the next col.
//If found, return true.
//Time: O(n+m)
//Space: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}