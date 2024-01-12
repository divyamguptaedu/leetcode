/**
Runtime: 4 ms, faster than 82.24% of Java online submissions for Valid Palindrome.
Memory Usage: 43.8 MB, less than 50.89% of Java online submissions for Valid Palindrome.
**/

class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char currStart = s.charAt(start);
            char currEnd = s.charAt(end);
            if (!Character.isLetterOrDigit(currStart )) {
                start++;
            } else if(!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(currStart) != Character.toLowerCase(currEnd)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}