"""
Performance:
Runtime: 65 ms, faster than 18.48% of Java online submissions for Regular Expression Matching.
Memory Usage: 39.2 MB, less than 38.94% of Java online submissions for Regular Expression Matching.
"""

class Solution {
    public boolean isMatch(String text, String pattern) {
    	// basic recursion;
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}