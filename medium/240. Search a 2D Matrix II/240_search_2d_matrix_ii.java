"""
Performance:
Runtime: 4 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix II.
Memory Usage: 44.6 MB, less than 67.33% of Java online submissions for Search a 2D Matrix II.
"""

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }
       
        int rowIndex = 0;
        int colIndex = matrix[0].length - 1;
        
        while (rowIndex < matrix.length && colIndex >= 0) {
            if (matrix[rowIndex][colIndex] == target) {
                return true;
            }     
            if(matrix[rowIndex][colIndex] < target) {
                rowIndex++;
            }
            else
                colIndex--;
        }
        
        return false;
    }    
    
}