/**
Runtime: 4 ms, faster than 82.24% of Java online submissions for Valid Palindrome.
Memory Usage: 43.8 MB, less than 50.89% of Java online submissions for Valid Palindrome.
**/

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}