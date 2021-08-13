""" 
Performance: 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
Memory Usage: 39.6 MB, less than 6.10% of Java online submissions for Search in Rotated Sorted Array.
"""

class Solution {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
        	int middle = (begin + end) / 2;
        	if (nums[middle] == target) {
        		return middle;
        	}
        	if (nums[begin] <= nums[middle]) {
        		if (target >= nums[begin] && target < nums[middle]) {
        			end = middle - 1;
        		} else {
        			begin = middle + 1;
        		}
        	} else {
        		if (target > nums[middle] && target <= nums[end]) {
        			begin = middle + 1;
        		} else {
        			end = middle - 1;
        		}
        	}
        }
        return -1;
    }
}