"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
Memory Usage: 56.1 MB, less than 59.02% of Java online submissions for Rotate Array.
"""

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
    	while (start < end) {
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    }
}