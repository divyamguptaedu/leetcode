"""
Performance:
Runtime: 4 ms, faster than 87.68% of Java online submissions for Maximal Square.
Memory Usage: 41.6 MB, less than 97.52% of Java online submissions for Maximal Square.
"""

class Solution {
    public int maximalSquare(char[][] matrix) {
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int max = 0;
    	int[][] storage = new int[row + 1][col + 1];
    	for (int i = 1; i <= row; i++) {
    		for (int j = 1; j <= col; j++) {
    			if (matrix[i - 1][j - 1] == '1') {
    				storage[i][j] = 1 + Math.min(storage[i - 1][j - 1], Math.min(storage[i - 1][j], storage[i][j - 1]));
    				max = Math.max(max, storage[i][j]);
    			}
    		}
    	}
    	return max * max;
    }
}