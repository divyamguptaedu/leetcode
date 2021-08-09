"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
Memory Usage: 39.1 MB, less than 47.10% of Java online submissions for Rotate Image.
"""

class Solution {
    public void rotate(int[][] matrix) {
    	int temp;
        // swap all i and j, only matrix.length / 2 times.
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < i; j++) {
        		temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
        // reverse each row
        for (int k = 0; k < matrix.length; k++) {
        	int left = 0;
        	int right = matrix.length - 1;
        	while (left < right) {
        		temp = matrix[k][left];
        		matrix[k][left] = matrix[k][right];
        		matrix[k][right] = temp;
        		left++;
        		right--;
        	}
        }
    }
}