"""
Performance:
Runtime: 497 ms, faster than 16.69% of Java online submissions for Target Sum.
Memory Usage: 36.7 MB, less than 72.87% of Java online submissions for Target Sum.
"""

public class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        helper(nums, 0, 0, target);
        return count;
    }

    // Recursed on all possible sums. Both increasing and decreasing.
    public void helper(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (sum == target)
                count++;
        } else {
            helper(nums, i + 1, sum + nums[i], target);
            helper(nums, i + 1, sum - nums[i], target);
        }
    }
}