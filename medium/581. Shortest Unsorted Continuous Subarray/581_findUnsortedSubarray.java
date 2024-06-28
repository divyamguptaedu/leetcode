//I approached the problem by identifying the minimum and maximum values within the unsorted subarray. 
//I iterated from left to right to find the first drop, marking the potential start of the unsorted subarray, 
//and kept track of the minimum value from that point. Similarly, 
//I iterated from right to left to find the first rise, marking the potential end of the unsorted subarray, 
//and kept track of the maximum value from that point. 
//Finally, I determined the leftmost and rightmost positions where these minimum and maximum values 
//should be placed to sort the subarray.
//Time: n
//Space: constant
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        boolean flag = false;
        
        // Find the minimum value in the unsorted subarray
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                minValue = Math.min(minValue, nums[i]);
            }
        }

        flag = false;

        // Find the maximum value in the unsorted subarray
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                maxValue = Math.max(maxValue, nums[i]);
            }
        }

        int left, right;

        // Determine the left boundary of the subarray
        for (left = 0; left < nums.length; left++) {
            if (minValue < nums[left]) {
                break;
            }
        }

        // Determine the right boundary of the subarray
        for (right = nums.length - 1; right >= 0; right--) {
            if (maxValue > nums[right]) {
                break;
            }
        }

        return right - left < 0 ? 0 : right - left + 1;
    }
}
