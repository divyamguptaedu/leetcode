"""
Performance:
Runtime: 1 ms, faster than 65.92% of Java online submissions for Integer Break.
Memory Usage: 38.8 MB, less than 97.72% of Java online submissions for Integer Break.
"""

class Solution {
    HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
    public int integerBreak(int n) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maximum = Math.max(maximum,i*helper(n-i));
        }
        return maximum;
    }
    private int helper(int n) {
        int maximum=Integer.MIN_VALUE;
        if (n == 0) {
            return 1;
        }
        if (result.containsKey(n)) {
            return result.get(n);
        }
        for (int i = 1; i <= n; i++) {
            maximum = Math.max(maximum, i * helper(n - i));
        }
        result.put(n, maximum);
        return maximum;
    }
}