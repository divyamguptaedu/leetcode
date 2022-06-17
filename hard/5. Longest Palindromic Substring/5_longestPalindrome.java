"""
Performance:
Runtime: 41 ms, faster than 72.79% of Java online submissions for Longest Palindromic Substring.
Memory Usage: 42.9 MB, less than 71.65% of Java online submissions for Longest Palindromic Substring.
"""

class Solution {
    public String longestPalindrome(String s) {
        int size = s.length();
        int start = 0;
        int end = 0;
        if (size < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = i;
            int k = i;
            while(j >= 0 && s.charAt(j) == c) {
                j--;
            }
            while(k < size && s.charAt(k) == c) {
                k++;
            }
            while(j >= 0 && k < size) {
                if (s.charAt(j) != s.charAt(k)) {
                    break;
                }
                j--;
                k++;
            }

            j += 1;
            if (end - start < k - j) {
                end = k;
                start = j;
            }
        }

        return s.substring(start, end);
    }
}