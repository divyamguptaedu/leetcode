//I approached the problem of determining whether an integer array can be partitioned into two subsets with equal sums. 
//Initially, I calculated the total sum of the array elements. If the sum is odd, partitioning isn't possible, so I returned false. 
//Otherwise, I halved the sum to determine the target sum for each subset. 
//Then, I utilized dynamic programming, initializing an array to track if a particular sum can be achieved using elements from the array.
//By iterating through the array and updating the dynamic programming array, I determined if the target sum could be achieved. 
//Finally, I returned the result based on the dynamic programming array.

//Time: O(mn) where m is the subsetSum and n is the #elements in nums
//Space: O(m)

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
        }
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;

        boolean dp[] = new boolean[sum + 1];
        // dp[i] = means is it possible to make sum i using array element
        dp[0] = true;// if no element of array include then sum will be zero

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) { // means required sum greater than num in nums
                    // dp[i] - means if num not inlcude ,
                    // dp[i-num] - means if num included , ans will now depend on value of i-num in
                    // dp
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[sum];

    }
}