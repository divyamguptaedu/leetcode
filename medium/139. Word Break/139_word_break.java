"""
Performance:
Runtime: 2 ms, faster than 92.55% of Java online submissions for Word Break.
Memory Usage: 39.1 MB, less than 68.43% of Java online submissions for Word Break.
"""

class Solution {
	HashMap<String, Boolean> storage = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
    	if (s.length() == 0) {
    		return true;
    	}
    	if (storage.containsKey(s) && !storage.get(s)) {
    		return false;
    	}
    	for (String string : wordDict) {
    		int length = string.length();
    		if (s.indexOf(string) == 0) {
    			if (wordBreak(s.substring(length), wordDict)) {
    				return true;
    			}
    		}
    	}
    	storage.put(s, false);
    	return false;
    }
}