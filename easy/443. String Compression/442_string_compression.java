"""
Performance:
Runtime: 20 ms, faster than 75.38% of Java online submissions for String Compression.
Memory Usage: 48.6 MB, less than 55.03% of Java online submissions for String Compression.
"""

class Solution {
    public int compress(char[] chars) {
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            boolean temp = (i == chars.length - 1) || (chars[i] != chars[i + 1]);
            result = result + chars[i];
            if (!temp) {
                int count = 1;
                while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                    count++;
                    i++;
                }
                result = result + String.valueOf(count);
            }
        }
        for (int i = 0; i < result.length(); i++) {
            chars[i] = result.charAt(i);
        }
        return result.length();
    }
}