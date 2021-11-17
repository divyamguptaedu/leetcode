"""
Performance:
Runtime: 1 ms, faster than 92.55% of Java online submissions for Gas Station.
Memory Usage: 59.9 MB, less than 42.14% of Java online submissions for Gas Station.
"""

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = gas.length-1;
        int sum = 0;
        for (int i = gas.length - 1; i >= 0; i--) {
            sum += gas[i] - cost[i];
            if (sum > maxVal) {
                maxVal = sum;
                maxIndex = i;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return maxIndex;
    }
}