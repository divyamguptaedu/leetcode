"""
Performance:
Runtime: 48 ms, faster than 48.53% of Java online submissions for Valid Triangle Number.
Memory Usage: 44.5 MB, less than 9.33% of Java online submissions for Valid Triangle Number.
"""

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) { 
           int left = 0;
           int right = i - 1;
           while (left < right) {
               if (nums[left] + nums[right] > nums[i]) {
                   count = count + (right - left);
                   right--;
               } else {
                   left++;
               }
           }
        }
        return count;
    }
}