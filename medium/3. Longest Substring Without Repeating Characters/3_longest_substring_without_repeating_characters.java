"""
Performance:
Runtime: 7 ms, faster than 40.44% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 39.7 MB, less than 24.74% of Java online submissions for Longest Substring Without Repeating Characters.
"""

class Solution {
	public int lengthOfLongestSubstring(String s) {
		
	    int i = 0;
	    int j = 0;
	    int max = 0;
	    Set<Character> set = new HashSet<>();
	    
	    // removes the first element of the set each time when a repeating string is found;
	    while (j < s.length()) {
	        if (!set.contains(s.charAt(j))) {
	            set.add(s.charAt(j++));
	            max = Math.max(max, set.size());
	        } else {
	            set.remove(s.charAt(i++));
	        }
	    }
	    
	    return max;
	}
}

//another solution

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int x = 0;
        int length = 0;
        int counter = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = x; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    x = j + 1;
                }
            }
            counter = i - x + 1;
            if (counter > length) {
                length = counter;
            }
        }
        return length;
    }
}