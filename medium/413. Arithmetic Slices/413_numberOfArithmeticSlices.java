"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Arithmetic Slices.
Memory Usage: 42.6 MB, less than 12.06% of Java online submissions for Arithmetic Slices.
"""

class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int size = arr.length;
        int current = 0;
        int previous = -1000000;
        int result = 0;
        for (int i = 1; i < size; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == previous) {
                current++;
                result += current;
            }
            else {
                previous = diff;
                current = 0;
            }
        }
        return result;
    }
}