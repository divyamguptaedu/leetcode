//I utilized dynamic programming to find the longest palindromic substring. 
//First, I initialized a boolean array to mark palindromes within the string. 
//Then, I iterated through the string, checking each possible substring for palindromic properties. 
//By considering the characters at both ends and checking if the inner substring is a 
//palindrome or has a length of two or less, I updated the dynamic programming table accordingly. 
//Throughout this process, I tracked the maximum palindrome length and its starting and 
//ending indices. Finally, I returned the substring corresponding to the longest palindrome found. 

//Time: O(n^2)
//Space: O(n^2)
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}