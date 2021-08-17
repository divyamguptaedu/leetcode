"""
Performance:
Runtime: 8 ms, faster than 53.51% of Java online submissions for Minimum Deletion Cost to Avoid Repeating Letters.
Memory Usage: 57 MB, less than 23.20% of Java online submissions for Minimum Deletion Cost to Avoid Repeating Letters.
"""

class Solution {
    public int minCost(String s, int[] cost) {
        if (s.length() == 1) {
            return 0;
        }
        int max = cost[0];
        int sum = cost[0];
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                max = Math.max(max, cost[i]);
                sum += cost[i];
                if (i == s.length() - 1) {
                    result += sum - max;
                }
            } else {
                result += sum - max;
                max = cost[i];
                sum = cost[i];
            }
        }
        return result;
    }
}