"""
Performance:
Runtime: 23 ms, faster than 22.35% of Java online submissions for Last Substring in Lexicographical Order.
Memory Usage: 42.7 MB, less than 32.40% of Java online submissions for Last Substring in Lexicographical Order.
"""

class Solution {
    public String lastSubstring(String s) {
        int left = 0;
        int maximum = 0;
        String result = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(left) >= 0) {
                String old = s.substring(left, i);
                if (result.compareTo(old) < 0) {
                    result = old;
                    maximum = left;
                }
                left = i;
            }
            while (i != s.length() -1 && s.charAt(i) == s.charAt(i+1)) {
                i++;
            }
            
        }

        if (result.compareTo(s.substring(left, s.length())) < 0) {
            maximum = left;
        }

        if (maximum == 1 && s.charAt(maximum) == s.charAt(0)) {
            maximum = 0;
        }
        return s.substring(maximum, s.length());
    }
}