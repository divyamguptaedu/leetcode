"""
Performance: 
Runtime: 10 ms, faster than 11.98% of Java online submissions for Valid Number.
Memory Usage: 45.2 MB, less than 5.88% of Java online submissions for Valid Number.
"""

class Solution {
    public boolean isNumber(String s) {
        char last = s.charAt(s.length() - 1);
        if ((last >= 'a' && last <= 'z') || (last >= 'A' && last <= 'Z')) {
            return false;
        }
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}