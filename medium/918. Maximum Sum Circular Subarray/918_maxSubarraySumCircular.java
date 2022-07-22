"
Performance:
Runtime: 7 ms, faster than 41.54% of Java online submissions for Maximum Sum Circular Subarray.
Memory Usage: 47.6 MB, less than 87.28% of Java online submissions for Maximum Sum Circular Subarray.
"

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int size = nums.length;
        int maximumNegative = Integer.MAX_VALUE;
        int maximumPositive = Integer.MIN_VALUE;
        int currentNegative = 0;
        int currentPositive = 0;
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int num = nums[i];
            currentNegative = Math.min(currentNegative + num, num);
            currentPositive = Math.max(currentPositive + num, num);
            maximum = Math.max(maximum, num);
            sum += num;
            maximumNegative = Math.min(maximumNegative, currentNegative);
            maximumPositive = Math.max(maximumPositive, currentPositive);
        }
        if (maximumPositive < 0) {
            return maximum;
        }
        return Math.max(sum - maximumNegative, maximumPositive);

    }
}