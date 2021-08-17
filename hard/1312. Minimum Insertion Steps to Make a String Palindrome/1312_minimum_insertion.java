"""
Performance:
Runtime: 17 ms, faster than 68.73% of Java online submissions for Minimum Insertion Steps to Make a String Palindrome.
Memory Usage: 39.9 MB, less than 92.71% of Java online submissions for Minimum Insertion Steps to Make a String Palindrome.
"""

class Solution {
	public int minInsertions(String s) {
        if (s == null || s.isEmpty()) {
        	return 0;
        }
        int n = s.length();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
        	array[i][i] = 1;
        }
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (k == 2) {
                    	array[i][j] = 2;
                    } else {
                    	array[i][j] = array[i + 1][j - 1] + 2;
                    }
                } else {
                    array[i][j] = Math.max(array[i][j - 1], array[i + 1][j]);
                }
            }
        }
        
        return n - array[0][n - 1];
    }
}