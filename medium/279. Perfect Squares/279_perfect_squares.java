"""
Performance:
Runtime: 22 ms, faster than 86.82% of Java online submissions for Perfect Squares.
Memory Usage: 38.4 MB, less than 41.75% of Java online submissions for Perfect Squares.
"""

class Solution {

    public int numSquares(int n) {

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, result[i - j * j]);
            }
            result[i] = min + 1;
        }
        
        return result[result.length - 1];
    }

}
