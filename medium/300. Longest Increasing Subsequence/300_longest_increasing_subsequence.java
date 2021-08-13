"""
Performance:
Runtime: 2 ms, faster than 99.06% of Java online submissions for Longest Increasing Subsequence.
Memory Usage: 38.8 MB, less than 43.34% of Java online submissions for Longest Increasing Subsequence.
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
            // use binary search to find position;
            int position = binarySearch(temp,length,nums[i]);
            if (nums[i] < temp[position]) temp[position] = nums[i];
            if (position > length) {
                length = position;
                temp[length] = nums[i];
            }
        }
        return length + 1;
    }

    // binary search, operates in logn time.
    private int binarySearch(int[] temp, int length, int val) {
        int left = 0;
        int right = length;
        while(left + 1 < right) {
            // find middle and choose side;
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