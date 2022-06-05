"
Performance:
Runtime: 78 ms, faster than 23.53% of Java online submissions for Guess Number Higher or Lower II.
Memory Usage: 42.1 MB, less than 46.25% of Java online submissions for Guess Number Higher or Lower II.
"

class Solution {
    public int getMoneyAmount(int n) {
        if (n <= 1) {
            return 0;
        }
        int[][] result = new int[n+1][n+1];
        return helper(0, n, result);
    }
    
    private int helper(int left, int right, int[][] result) {
        if (left >= right) {
            return 0;
        }
        if (result[left][right] > 0) {
            return result[left][right];
        }
        int answer = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int cost = i + Math.max(helper(left, i - 1, result), helper(i + 1, right, result));
            answer = Math.min(answer, cost);
        }
        result[left][right] = answer;
        return answer;
    }
}