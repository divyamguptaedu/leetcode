"
Performance:
Runtime: 41 ms, faster than 95.33% of Java online submissions for Longest Palindromic Subsequence.
Memory Usage: 71.9 MB, less than 22.91% of Java online submissions for Longest Palindromic Subsequence.
"

class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        return helper(s, 0, length - 1, new int[length][length]);
    }
    int helper(String s, int i, int j, int[][] result) {
        if (result[i][j] != 0) {
            return result[i][j];
        }
        if (i == j) {
            return 1;
        } else if (i > j) {
            return 0;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return result[i][j] 
                = helper(s, i + 1, j - 1, result) + 2;
        } else {
            return result[i][j] 
                = Math.max(helper(s, i + 1, j, result), helper(s, i, j - 1, result));
        }
    }
}