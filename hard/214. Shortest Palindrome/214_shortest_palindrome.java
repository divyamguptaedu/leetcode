"
Performance:
Runtime: 656 ms, faster than 5.03% of Java online submissions for Shortest Palindrome.
Memory Usage: 39.4 MB, less than 36.80% of Java online submissions for Shortest Palindrome.
"

public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int maxIndex = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (helper(s, 0, i)) {
                maxIndex = i;
                break;
            }
        }

        if (maxIndex == s.length() - 1) {
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder(s.substring(maxIndex + 1, s.length()));
        return stringBuilder.reverse().append(s).toString();
    }

    private boolean helper(String s, int left, int right) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}