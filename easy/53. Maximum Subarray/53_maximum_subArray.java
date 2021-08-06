"""
Performance:
Runtime: 1 ms, faster than 46.61% of Java online submissions for Maximum Subarray.
Memory Usage: 38.7 MB, less than 90.24% of Java online submissions for Maximum Subarray.
"""
class Solution {
    public static int maxSubArray(int[] nums) {
        int maximum = nums[0];
        int[] array = new int[nums.length];
        array[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            array[i] = Math.max(nums[i], array[i - 1] + nums[i]);
            maximum = Math.max(maximum, array[i]);
        }
        
        return maximum;
    }
}