"""
Performance:
Runtime: 310 ms, faster than 13.42% of Java online submissions for Palindromic Substrings.
Memory Usage: 39.2 MB, less than 30.54% of Java online submissions for Palindromic Substrings.
"""

class Solution {
    public int countSubstrings(String s) {
    	int count = 0;
    	for (int i = 0; i < s.length(); i++) {
    		for (int j = i + 1; j < s.length() + 1; j++) {
    			// get the substring and check if it's a palindrome
    			if (isPalindrome(s.substring(i, j))) {
    				count++;
    			}
    		}
    	}
        return count;
    }
    
    // checks if the passed in string is a palindrome using pointer approach.
    private boolean isPalindrome(String s) {
    	int i = 0;
    	int j = s.length() - 1;

    	while(i <= j) {
    		if (s.charAt(i) != s.charAt(j)) {
    			return false;
    		} else {
    			i++;
    			j--;
    		}
    	}
    	return true;
    }
    
}