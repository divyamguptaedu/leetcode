"""
Performance:
Runtime: 309 ms, faster than 5.11% of Java online submissions for Trapping Rain Water.
Memory Usage: 38.6 MB, less than 49.15% of Java online submissions for Trapping Rain Water.
"""

import java.util.Arrays;

class Solution {
    public int trap(int[] height) {
        int result = 0;
        result = calWater(height, result);
        return result;
    }

    private int calWater(int[] height, int result) {
        int leftMax = 0;
        int rightMax = 0;
        int minimum;
        for (int i = 0; i < height.length; i++) {
            leftMax = findLeftMax(height, i);
            rightMax = findRightMax(height, i);
            minimum = Math.min(height[leftMax], height[rightMax]);
            if (minimum - height[i] > 0) {
                result += minimum - height[i];
            }
        }
        return result;
    }

    private int findRightMax(int[] height, int index) {
        if (index == height.length - 1) {
            return index;
        }
        int maximum = index;
        for (int i = index + 1; i < height.length; i++) {
            if (height[i] > height[maximum]) {
                maximum = i;
            }
        }
        return maximum;
    }

    private int findLeftMax(int[] height, int index) {
        if (index == 0) {
            return 0;
        }
        int maximum = index;
        for (int i = index - 1; i >= 0; i--) {
            if (height[i] > height[maximum]) {
                maximum = i;
            }
        }
        return maximum;
    }
}