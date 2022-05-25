"""
Performance:
Runtime: 2 ms, faster than 99.90% of Java online submissions for Zigzag Conversion.
Memory Usage: 42.2 MB, less than 99.13% of Java online submissions for Zigzag Conversion.
"""

class Solution {
    public String convert(String s, int numRows) {
        int size = s.length();
        if (size < numRows || numRows <= 1) {
            return s;
        }
        char[] result = new char[size];
        int index = 0;
        int section = (2 * numRows) - 2;
        for (int i = 0; i < numRows; i++) {
            int stage = section - 2 * i;
            for (int j = i; j < size; j += section) {
                result[index++] = s.charAt(j);
                if (stage > 0 && stage < section && j + stage < size) {
                    result[index++] = s.charAt(j + stage);
                }
            }
        }
        return new String(result);
    }
}