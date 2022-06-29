"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Beautiful Arrangement II.
Memory Usage: 42.4 MB, less than 99.35% of Java online submissions for Beautiful Arrangement II.
"

class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        for (int i = k; i < n; i++) {
            result[i] = i + 1;
        }
        for (int i = k - 1, val = 1; i >= 0; i -= 2) {
            result[i] = val++;
        }
        for (int i = k - 2, val = k; i >= 0; i -= 2) {
            result[i] = val--;
        }
        return result;
    }
}