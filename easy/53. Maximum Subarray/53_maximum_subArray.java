"""
Performance:
Runtime: 1 ms, faster than 46.61% of Java online submissions for Maximum Subarray.
Memory Usage: 38.7 MB, less than 90.24% of Java online submissions for Maximum Subarray.
"""
class Solution {
    public static int maxSubArray(int[] nums) {
        // variable to store the largest sum
        int maximum = nums[0];
        // array to store the new maximums
        int[] array = new int[nums.length];
        array[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // add the maximum of sum and the new number.
            array[i] = Math.max(nums[i], array[i - 1] + nums[i]);
            // choose the maximum of old sum and new sum.
            maximum = Math.max(maximum, array[i]);
        }
        
        return maximum;
    }
}