"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
Memory Usage: 35.9 MB, less than 49.44% of Java online submissions for Unique Paths.
"""

class Solution {
    public int uniquePaths(int m, int n) {
        int[] array = new int[n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i == 0 || j == 0) {
        			array[j] = 1;
        		} else {
        			array[j] += array[j - 1];
        		}
        	}
        }
        int sum = array[n - 1];
        return sum;
    }
}