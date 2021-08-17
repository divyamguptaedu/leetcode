class Solution {
    public int minCost(String s, int[] cost) {
        if (s.length() == 1) {
            return 0;
        }
        int max = cost[0];
        int sum = cost[0];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                max = Math.max(max, cost[i]);
                sum += cost[i];
                if (i == s.length() - 1) {
                    res += sum - max;
                }
            } else {
                res += sum - max;
                max = cost[i];
                sum = cost[i];
            }
        }
        return res;
    }
}