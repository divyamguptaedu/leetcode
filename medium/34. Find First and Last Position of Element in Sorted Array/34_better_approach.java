"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 44.5 MB, less than 5.86% of Java online submissions for Find First and Last Position of Element in Sorted Array.
"""

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        
        while (start <= end) { // searching first occurance
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                ans[0] = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        start = 0;
        end = nums.length - 1;
        while (start <= end) { // searching last occurance
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                ans[1] = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid+1;
            } else end = mid - 1;
        }
        return ans;
    }
}