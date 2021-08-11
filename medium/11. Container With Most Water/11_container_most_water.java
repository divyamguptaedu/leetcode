"""
Performance:
Runtime: 3 ms, faster than 81.96% of Java online submissions for Container With Most Water.
Memory Usage: 52.7 MB, less than 46.81% of Java online submissions for Container With Most Water.
"""

class Solution {
    public int maxArea(int[] height) {
        int result = 0;
    	if (height.length == 0 || height.length == 1) {
    		return result;
    	}
    	int left = 0;
    	int right = height.length - 1;


    	while (right > left) {
            // compute volume between left and right;
    		int temp = (right - left) * (Math.min(height[left], height[right]));

            // if right is larger, increment left;
    		if (height[right] > height[left]) {
    			result = Math.max(result, temp);
    			left++;

            // if left is larger, decrement right;
    		} else {
    			result = Math.max(result, temp);
    			right--;
    		}
    	}
    	return result;
    }
}