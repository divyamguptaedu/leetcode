"
Performance:
Runtime: 115 ms, faster than 89.53% of Java online submissions for Image Overlap.
Memory Usage: 42.7 MB, less than 88.37% of Java online submissions for Image Overlap.
"

class Solution {
    public int largestOverlap(int[][] a, int[][] b) {
		int maximum = 0;
		for (int i = 1 - a.length; i < a.length; i++) {
			for (int j = 1 - a[0].length; j < a.length; j++) {
				maximum = Math.max(maximum, helper(a, b, i, j));
			}
		}
		return maximum;
	}

	private int helper(int[][] a, int[][] b, int x, int y) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (i - x >= 0 && j - y >= 0 && i - x < a.length && j - y < a[0].length) {
					if (a[i][j] == b[i - x][j - y] && a[i][j] == 1) {
						count++;
					}
				}
			}
		}
		return count;
	}
}