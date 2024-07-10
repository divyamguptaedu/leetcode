// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int pref_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            pref_sum += nums[i];
            
            // Check if the current prefix sum equals k
            if (pref_sum == k) {
                answer++;
            }
            
            // Check if there exists a previous prefix sum that makes the difference k
            answer += map.getOrDefault(pref_sum - k, 0);
            
            // Update the frequency of the current prefix sum
            map.put(pref_sum, map.getOrDefault(pref_sum, 0) + 1);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Number of subarrays with sum " + k1 + ": " + solution.subarraySum(nums1, k1));
        
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Number of subarrays with sum " + k2 + ": " + solution.subarraySum(nums2, k2));
    }
}
