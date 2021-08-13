"""
Performance: 
Runtime: 1 ms, faster than 14.69% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 42.6 MB, less than 12.25% of Java online submissions for Find First and Last Position of Element in Sorted Array.
"""

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int j = 0;
        for (int i = 0; i < nums.length; i++) { 
            if (j == 0) {
                if (nums[i] == target) {
                    j++;
                    result[0] = i;
                    result[1] = i;
                }
            } else {
                if (nums[i] == target) {
                    result[1] = i;
                }
            }
        }
        return result;
    }
}