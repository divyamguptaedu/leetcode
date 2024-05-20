//I used dynamic programming. I created a 2D array dp where dp[i][j] indicates if text[i:] matches pattern[j:]. 
//I initialized dp[text.length()][pattern.length()] to true since an empty text matches an empty pattern. 
//I then iterated through the text and pattern in reverse. 
//For each character in the pattern, I checked if it matched the current character in the text or if it was a '.'. 
//If the next character in the pattern was a '*', 
//I considered both zero occurrences and one or more occurrences of the preceding character. 
//Finally, I returned dp[0][0].

//Time: O(TP) where t and p are the length of text and pattern
//Space: O(TP)
class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match =
                    (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (first_match && dp[i + 1][j]);
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}