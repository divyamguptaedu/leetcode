"""
Performance:
Runtime: 4 ms, faster than 97.70% of Java online submissions for Unique Substrings in Wraparound String.
Memory Usage: 42.2 MB, less than 87.10% of Java online submissions for Unique Substrings in Wraparound String.
"""

class Solution {
    public int findSubstringInWraproundString(String p) {
        int size = p.length();
        int result = 0;
        int length = 1;
        int[] counts = new int[26];
        for (int i = 0; i < size; i++) {
            char temp = p.charAt(i);
            if (i > 0 && (temp - p.charAt(i-1) == 1 || temp - p.charAt(i-1) == -25)) {
                length++;
            } else {
                length = 1;
            }
            int index = temp - 'a';
            counts[index] = Math.max(counts[index], length);
        }
        for (int count : counts) {
            result += count;
        }
        return result;
    }
}