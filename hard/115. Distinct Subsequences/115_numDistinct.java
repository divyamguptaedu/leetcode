"""
Performance:
Runtime: 23 ms, faster than 63.48% of Java online submissions for Distinct Subsequences.
Memory Usage: 50 MB, less than 58.08% of Java online submissions for Distinct Subsequences.
"""
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int result[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                result[i][j] = -1;
            }
        }
        return helper(n - 1, m - 1, s, t, result);
    }
    
    public int helper(int i ,int j, String s1, String s2,int result[][]) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (result[i][j] != -1) {
            return result[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return result[i][j] = (helper(i - 1, j - 1, s1, s2, result) + helper(i - 1, j, s1, s2, result));
        } else { 
            return result[i][j] = helper(i-1,j,s1,s2,result);
        }   
    }
}

