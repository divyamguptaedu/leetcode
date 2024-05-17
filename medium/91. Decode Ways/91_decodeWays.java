//I approached this problem by using dynamic programming.
//I initialized an array dp to store the number of ways to decode substrings of the input string s. 
//I iterated through the string and computed the number of ways to decode substrings of length 1 and 2, 
//considering the cases where the current digit or the previous two digits form a valid mapping to a letter. 
//I accumulated the counts in the dp array as I progressed through the string, 
//ensuring that each substring was decoded correctly. 
//Finally, I returned the count stored in dp[n], where n is the length of s.

//Time: O(n) where n is the length of the string
//Space: O(n)
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit != 0) {
                dp[i] += dp[i - 1];
            }

            if (10 <= twoDigits && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}