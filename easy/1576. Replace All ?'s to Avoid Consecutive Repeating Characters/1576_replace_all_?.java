"
Performance:
Runtime: 1 ms, faster than 100.00% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
Memory Usage: 39.2 MB, less than 46.37% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
"

class Solution {
	public String modifyString(String s) {
	    if (s == null || s.isEmpty()) {
	    	return "";
	    }
	    char[] chars = s.toCharArray();
	    for (int i = 0; i < chars.length; i++) {
	        if (chars[i] == '?') {
	            for (char j = 'a'; j <= 'z'; j++) {
	                chars[i] = j;
	                if (i > 0 && chars[i - 1] == j) continue;
	                if (i < chars.length - 1 && chars[i + 1] == j) continue;
	                break;
	            }
	        }
	    }
	    
	    return new String(chars);
	}
}