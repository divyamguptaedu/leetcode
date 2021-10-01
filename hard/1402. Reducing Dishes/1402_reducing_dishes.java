"""
Performance:
Runtime: 1 ms, faster than 99.33% of Java online submissions for Reducing Dishes.
Memory Usage: 36.6 MB, less than 96.64% of Java online submissions for Reducing Dishes.
"""

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0;
        int result = 0;
        int size = satisfaction.length;
        for (int i = size-1; i >= 0 && satisfaction[i] + sum > 0; i--) {
            sum += satisfaction[i];
            result += sum;
        }
        return result;
    }
}