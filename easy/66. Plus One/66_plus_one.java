"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
Memory Usage: 37.1 MB, less than 95.47% of Java online submissions for Plus One.
"""

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}