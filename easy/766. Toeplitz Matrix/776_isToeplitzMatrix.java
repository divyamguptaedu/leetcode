//I iterated through the matrix starting from the second row and second column. 
//For each element, I compared it to the element diagonally above and to the left. 
//If any element did not match its diagonal counterpart, I returned false, 
//indicating the matrix was not Toeplitz. If all elements matched their diagonals, 
//I returned true at the end.

//Time: O(mn) where mn is the dimention of the matrix
//Space: O(1)
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {  // Start from the second row
            for (int j = 1; j < matrix[i].length; j++) {  // Start from the second column
                // Check if current element matches the element diagonally above and left
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;  // Return false if a mismatch is found
                }
            }
        }
        return true;  // Return true if all elements matched their diagonals
    }
}