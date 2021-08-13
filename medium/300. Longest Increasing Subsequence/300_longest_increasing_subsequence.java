"""
Performance:
"""

public class Solution {
	
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        int length = 0;
        for (int i = 1; i < nums.length; i++) {
            int position = binarySearch(temp,length,nums[i]);
            if (nums[i] < temp[position]) temp[position] = nums[i];
            if (position > length) {
                length = position;
                temp[length] = nums[i];
            }
        }
        return length + 1;
    }

    private int binarySearch(int[] temp, int length, int val) {
        int left = 0;
        int right = length;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (temp[mid] == val) {
                return mid;
            } else {
                if (temp[mid] < val) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (temp[right] < val) {
        	return length + 1;
        }
        else if (temp[left] >= val) {
        	return left;
        }
        else {
        	return right;
        }
    }
}