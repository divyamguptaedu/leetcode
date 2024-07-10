// Given an integer array nums and an integer k, return the maximum length of a 
// subarray that sums to k. If there is not one, return 0 instead.

import java.util.*;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            
            // Check if current sum equals k directly
            if (currSum == k) {
                maxLen = i + 1;
            }
            
            // Check if there exists a previous sum that makes the difference k
            if (map.containsKey(currSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(currSum - k));
            }
            
            // Store the first occurrence of the current sum
            if (!map.containsKey(currSum)) {
                map.put(currSum, i);
            }
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        int[] nums1 = {1, -1, 5, -2, 3};
        int k1 = 3;
        System.out.println("Max length of subarray with sum " + k1 + ": " + solution.maxSubArrayLen(nums1, k1));
        
        int[] nums2 = {-2, -1, 2, 1};
        int k2 = 1;
        System.out.println("Max length of subarray with sum " + k2 + ": " + solution.maxSubArrayLen(nums2, k2));
    }
}
