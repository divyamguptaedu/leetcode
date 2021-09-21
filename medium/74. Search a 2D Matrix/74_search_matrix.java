"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
Memory Usage: 38.9 MB, less than 36.08% of Java online submissions for Search a 2D Matrix.

"""

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][matrix[0].length - 1]) {
                index = i;
                break;
            }
        }
        
        for (int i = matrix[0].length-1; i >= 0; i--) {
            if (target == matrix[index][i]) {
                return true;
            }
        }
        return false;
    }
}