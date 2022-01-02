"""
Performance:
Runtime: 69 ms, faster than 25.27% of Java online submissions for Scramble String.
Memory Usage: 39.6 MB, less than 60.25% of Java online submissions for Scramble String.
"""

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        
        return helper(s1, s2);
    }
    
    Map<String,Boolean> valueMap = new HashMap<>();
    
    public boolean helper (String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        String key = s1 + "*" + s2;
        if (valueMap.containsKey(key)) {
            return valueMap.get(key);
        }
        int length = s1.length();
        for (int i = 1; i < length; i++) {
            if ((helper(s1.substring(0, i), s2.substring(length - i)) 
                 && helper(s1.substring(i), s2.substring(0, length - i))) ||
                (helper(s1.substring(0, i), s2.substring(0, i)) 
                 && helper(s1.substring(i), s2.substring(i)))) {
                valueMap.put(key, true);
                return true;
            }
        }
        valueMap.put(key,false);
        return false;
    }
}