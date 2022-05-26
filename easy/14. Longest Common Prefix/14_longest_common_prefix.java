"""
Performance:
Runtime: 1 ms, faster than 82.60% of Java online submissions for Longest Common Prefix.
Memory Usage: 41.8 MB, less than 63.57% of Java online submissions for Longest Common Prefix.
"""
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char value = strs[0].charAt(i);
            boolean same = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != value) {
                    same = false;
                    break;
                }
            }
            if (same) {
               result.append(value); 
            }
            else {
                break;
            }
        }
        return result.toString();        
    }
}