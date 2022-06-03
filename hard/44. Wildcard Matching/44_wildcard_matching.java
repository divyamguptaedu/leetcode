"""
Performance: 
Runtime: 62 ms, faster than 22.28% of Java online submissions for Wildcard Matching.
Memory Usage: 48.9 MB, less than 33.62% of Java online submissions for Wildcard Matching.
"""

class Solution {
    public boolean isMatch(String s, String p) {
        int s_length = s.length();
        int p_length = p.length();
        boolean result[][] = new boolean[s_length + 1][p_length + 1];
        result[0][0] = true;
        for (int i = 0; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (i == 0) {
                    if (p.charAt(j - 1) == '*') {
                        result[i][j] = result[i][j - 1]; 
                    } else {
                        result[i][j] = false;
                    }
                } else {
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                        result[i][j] = result[i - 1][j - 1];
                    } else if(p.charAt(j - 1) == '*') {
                        result[i][j] = result[i - 1][j] || result[i][j - 1];
                    }    
                }
            }
        }
        return result[s_length][p_length];
    }
}