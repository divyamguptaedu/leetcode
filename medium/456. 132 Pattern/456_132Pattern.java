class Solution {
    public boolean find132pattern(int[] nums) {
        int size = nums.length;
        int top = size;
        int third = Integer.MIN_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            }
            while (top < size && nums[i] > nums[top]) {
                third = nums[top++];
            }
            nums[top--] = nums[i];
        }
        return false;
    }
}