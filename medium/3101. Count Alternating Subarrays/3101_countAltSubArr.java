//I counted alternating subarrays in a binary array. 
//In the countAlternatingSubarrays method, I initialized an array dp to store the length of 
//alternating subarrays ending at each index. I iterated through the array, 
//updating dp[i] based on whether nums[i] is different from nums[i - 1]. If they are different, 
//I incremented dp[i] by 1, indicating the continuation of an alternating subarray; otherwise, 
//I reset dp[i] to 1. I kept track of the total count of alternating subarrays and returned it. 
//This approach efficiently counts alternating subarrays by utilizing dynamic programming.

//Time: O(n)
//Space: O(n)

class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // Stores length of alternating subarrays ending at each index
        long count = 1; // Initialize count to 1
        dp[0] = 1; // Initialize dp[0] to 1
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                dp[i] = dp[i - 1] + 1; // If current and previous elements are different, increment dp[i]
            } else {
                dp[i] = 1; // If current and previous elements are same, reset dp[i] to 1
            }
            count += dp[i]; // Increment count by dp[i]
        }
        return count; // Return the total count of alternating subarrays
    }
}
