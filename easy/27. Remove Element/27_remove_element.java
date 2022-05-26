"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
Memory Usage: 42.2 MB, less than 63.84% of Java online submissions for Remove Element.
"""
class Solution {
    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }
}