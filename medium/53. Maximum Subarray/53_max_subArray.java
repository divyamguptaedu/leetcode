//Initially, I set the answer to the smallest possible integer value and started iterating through the array. 
//While traversing, I accumulated the sum of elements and updated the answer whenever I encountered a sum larger 
//than the current answer. If the sum turned negative, indicating potential decrement in the maximum sum, 
//I reset it to zero. Finally, I returned the maximum sum found. 

//Time: O(N)
//Space: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > ans) {
                ans = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}