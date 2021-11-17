"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
Memory Usage: 38.7 MB, less than 36.47% of Java online submissions for Find Minimum in Rotated Sorted Array.
"""

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];       
            }
            int middle = start + (end - start) / 2;
            if (nums[middle] < nums[start]) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return nums[start];
    }
}