"
Performance:
Runtime: 8 ms, faster than 100.00% of Java online submissions for Check if a Parentheses String Can Be Valid.
Memory Usage: 39.9 MB, less than 56.24% of Java online submissions for Check if a Parentheses String Can Be Valid.
"

class Solution {
    public boolean canBeValid(String s, String locked) {
        int maximumLength = 0;
        int minimumLength = 0;
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    minimumLength++;
                    maximumLength++;
                } else {
                    if (maximumLength < 1) {
                        return false;
                    }
                    maximumLength--;
                    if (minimumLength > 0) {
                        minimumLength--;
                    }
                }
            } else {
                maximumLength++;
                if (minimumLength > 0) {
                    minimumLength--;
                }
            }
        }
        return minimumLength == 0;
    }
}