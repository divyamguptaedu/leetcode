"""
Performance:
Runtime: 1 ms, faster than 83.97% of Java online submissions for Trapping Rain Water.
Memory Usage: 38.7 MB, less than 49.15% of Java online submissions for Trapping Rain Water.
"""

class Solution {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int rightmax = 0;
        int leftmax = 0;
        int result = 0;

        while (left <= right) {
            if (leftmax <= rightmax) {
                if (height[left] >= leftmax) {
                    leftmax = height[left];
                }
                else {
                    result += (leftmax - height[left]);
                }
                left++;
            }
            else {
                if (height[right] >= rightmax) {
                    rightmax = height[right];
                }
                else {
                    result += (rightmax - height[right]);
                }
                right--;
            }
        }
        return result;
    }

}