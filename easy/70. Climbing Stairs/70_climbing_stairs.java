"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
Memory Usage: 35.6 MB, less than 71.36% of Java online submissions for Climbing Stairs.
"""
class Solution {
    public int climbStairs(int n) {
        int[] storage = new int[n + 1];
        return climbStairsHelper(n, storage);
    }
    
    private int climbStairsHelper(int n, int[] storage) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (storage[n] > 0) {
            return storage[n];
        }
        int downOneStep = climbStairsHelper(n - 1, storage);
        int downTwoStep = climbStairsHelper(n - 2, storage);
        storage[n] = downOneStep + downTwoStep;
        return downOneStep + downTwoStep;
    }
}