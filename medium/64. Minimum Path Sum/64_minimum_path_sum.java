"""
Performance:
Runtime: 1 ms, faster than 98.45% of Java online submissions for Minimum Path Sum.
Memory Usage: 41.9 MB, less than 39.81% of Java online submissions for Minimum Path Sum.
"""

class Solution {

	public int minPathSum(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		for (int j = 1; j < m; j++) {
			grid[0][j] += grid[0][j - 1];
		}

		for (int i = 1; i < n; i++) {
			grid[i][0] += grid[i - 1][0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}

		int minimum = grid[n - 1][m - 1];
		return minimum;

	}
}













