"
Performance:
Runtime: 66 ms, faster than 65.04% of Java online submissions for Isomorphic Strings.
Memory Usage: 42.8 MB, less than 62.97% of Java online submissions for Isomorphic Strings.
"

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char tempOne = s.charAt(i);
            char tempTwo = t.charAt(i);
            if (map.containsKey(tempOne)) {
                if (map.get(tempOne) != tempTwo) {
                    return false;
                }
            } if (map.containsValue(tempTwo) && !map.containsKey(tempOne)) {
                return false;
            }
            else {
                map.put(tempOne,tempTwo);
            }
        }
        return true;
    }
}