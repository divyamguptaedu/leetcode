//I used dynamic programming to solve this problem. 
//I converted the input strings into character arrays and initialized a 2D `dp` array 
//to store the lengths of the longest common subsequences (LCS). 
//I filled this `dp` table by comparing characters from both strings. 
//After building the `dp` table, I traced back from the bottom-right corner to construct 
//the shortest common supersequence. I appended matching characters from both strings, 
//and for non-matching characters, I chose the direction with the larger value in the `dp` table. 
//Finally, I added any remaining characters from both strings and 
//reversed the result to get the final string.

//Time: O(nm) where n and m is the length of strings.
//Space: O(nm)
class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {

        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];
        // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= m; j++)
            dp[0][j] = 0;

        // filling dp table and length of lcs
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s[i - 1] == t[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        // finding lcs from dp table
        while (i > 0 && j > 0) {
            // if current character matches
            if (s[i - 1] == t[j - 1]) {
                sb.append(s[i - 1]);
                i--;
                j--;
            }
            // if left cell is greater we will move left and will add char t[j-1] to ans.
            else if (dp[i - 1][j] <= dp[i][j - 1]) {
                sb.append(t[j - 1]);
                j--;
            }
            // up cell is greater we will move up and will add char s[i-1] to ans.
            else {
                sb.append(s[i - 1]);
                i--;
            }
        }

        // adding remaining character of both string.
        while (i-- > 0)
            sb.append(s[i]);
        while (j-- > 0)
            sb.append(t[j]);

        return sb.reverse().toString();
    }
}