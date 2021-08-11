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

    private String helper(String s, int i, int j) {
    	while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
    		i--;
    		j++;
    	}
    	return s.subString(i + 1, j);
    }
    
}