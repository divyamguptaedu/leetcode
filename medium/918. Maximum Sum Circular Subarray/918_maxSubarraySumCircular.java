//Initially, I calculated the maximum subarray sum using Kadane's algorithm and stored it. 
//Then, I adapted Kadane's algorithm to find the minimum subarray sum. 
//After obtaining the total sum of all array elements, I handled the edge case where the minimum subarray sum equals the total sum, 
//implying an empty subarray, which is invalid. 
//Finally, I returned the maximum of either the maximum subarray sum 
//or the difference between the total sum and the minimum subarray sum.

//Time: O(n)
//Space: O(1)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0;
        int curMin = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int totalSum = 0;
        
        for (int num: nums) {
            // Normal Kadane's
            curMax = Math.max(curMax, 0) + num;
            maxSum = Math.max(maxSum, curMax);
            
            // Kadane's but with min to find minimum subarray
            curMin = Math.min(curMin, 0) + num;
            minSum = Math.min(minSum, curMin);
            
            totalSum += num;  
        }

        if (totalSum == minSum) {
            return maxSum;
        }
        
        return Math.max(maxSum, totalSum - minSum);
    }
}