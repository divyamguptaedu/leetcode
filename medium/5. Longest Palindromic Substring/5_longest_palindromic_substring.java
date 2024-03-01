"""
Performance:
Runtime: 31 ms, faster than 50.50% of Java online submissions for Longest Palindromic Substring.
Memory Usage: 39.7 MB, less than 37.90% of Java online submissions for Longest Palindromic Substring.
"""

class Solution {

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
        	return null;
        }
        if (s.length() == 1) {
        	return s;
        }


        String longest = s.subString(0, 1);
        for (int i = 0; i < s.length(); i++) {
        	String temp = helper(s, i, i);
        	if (temp.length() > longest.length()) {
        		longest = temp;
        	}
        	temp = helper(s, i, i + 1);
        	if (temp.length() > longest.length()) {
        		longest = temp;
        	}
        }
        return longest;
    }

    // helper to get the maximum length palindrome;
    private String helper(String s, int i, int j) {
    	while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
    		i--;
    		j++;
    	}
    	return s.subString(i + 1, j);
    }
    
}

//another solution

class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            List<Integer> indexes = helperGetIndexes(s.substring(i), s.charAt(i), i);
            for (Integer index: indexes) {
                if (isPalindrome(s.substring(i, index + 1))) {
                    if (result.length() < s.substring(i, index + 1).length()) {
                        result = s.substring(i, index + 1);
                    }
                    break;
                }
            }
        }
        return result;
    }
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++ ) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    private List<Integer> helperGetIndexes(String s, char letter, int buffer) {
        List<Integer> indexes = new ArrayList();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == letter) {
                indexes.add(i + buffer);
            }
        }
        return indexes;
    }
}