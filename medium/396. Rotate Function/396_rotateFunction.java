"""
Performance:
Runtime: 5 ms, faster than 53.95% of Java online submissions for Rotate Function.
Memory Usage: 92.4 MB, less than 10.87% of Java online submissions for Rotate Function.
"""

class Solution {
    public int maxRotateFunction(int[] nums) {
        int i;
        int sum = 0;
        int result = 0;
        int maximum;
        int n = nums.length - 1;
        for (i = 0; i <= n; i++) {
            sum += nums[i];
            result += nums[i] * i;
        }
        maximum = result;
        for (i = 0; i <= n; i++) {
            result = result - sum + nums[i] + (nums[i] * n);
            maximum = Math.max(result, maximum);
        }
        return maximum;
    }
}