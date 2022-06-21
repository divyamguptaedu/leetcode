"""
Performance:
Runtime: 5 ms, faster than 64.54% of Java online submissions for Minimum Moves to Equal Array Elements II.
Memory Usage: 45.6 MB, less than 54.94% of Java online submissions for Minimum Moves to Equal Array Elements II.
"""

class Solution {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while(left < right) {
            result += nums[right] - nums[left];
            left++;
            right--;
        }
        return result;
    }
}
}