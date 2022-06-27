"""
Performance:
Runtime: 11 ms, faster than 88.62% of Java online submissions for Maximum Length of Pair Chain.
Memory Usage: 54 MB, less than 44.68% of Java online submissions for Maximum Length of Pair Chain.
"""

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int result = 0;
        int current = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > current) {
                result++;
                current = pair[1];
            }
        }
        return result;       
    }
}