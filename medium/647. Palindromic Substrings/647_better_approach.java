"""
Performance:
isPalindrome function now uses recursion, instead of the pointer approach used initially.
128/130 test cases passed with this approach. Need to optimize solution for longer strings like "s" * 1000.
"""

class Solution {
    public int countSubstrings(String s) {
    	int count = 0;
    	for (int i = 0; i < s.length(); i++) {
    		for (int j = i + 1; j < s.length() + 1; j++) {
    			if (isPalindrome(s.substring(i, j))) {
    				count++;
    			}
    		}
    	}
        return count;
    }
    
    private boolean isPalindrome(String s) {

        if (s.length() < 2) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        return isPalindrome(s.substring(1, s.length() - 1));
    }
    
}