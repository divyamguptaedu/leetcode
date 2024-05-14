//We can use DP to solve this question. Note that, for each element either we can chose it in the current subarray 
//or choose to start a new subarray from this element.
//Partitioned the array into contiguous subarrays of at most length k. 
//For each subarray, I find the maximum value. Then, I calculate the maximum sum of the array after partitioning. 
//I iterate from the end to the beginning of the array, updating the maximum sum using dynamic programming. 
//I maintain a DP array to store the maximum sum at each position. Finally, I return the maximum sum from the DP array.

//Time: O(NK)
//Space: O(N)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);

        for (int start = N - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(N, start + k);

            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                // Store the maximum of all options for the current subarray.
                dp[start] = Math.max(dp[start], dp[i + 1] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }
}