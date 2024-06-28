//I approached the problem by using dynamic programming and recursion to calculate the maximum number of //
//indices that can be visited from each starting index. I iterated through the array and used a helper 
//function to compute the maximum jumps possible from each index, considering jumps within the given distance d. 
//I kept track of the results in a memoization array to avoid redundant calculations. 
//The result for each index was determined by exploring all valid jumps to both the left and right, 
//updating the maximum jumps for that index.

//Time: n*d 
//Space: n
class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int max = 0;

        // dp array to store the maximum jumps from each index
        int[] dp = new int[n];

        // Iterate over each index to find the maximum jumps starting from that index
        for (int i = 0; i < n; i++) {
            max = Math.max(max, helper(arr, d, i, dp));
        }

        return max;
    }

    // Helper function to calculate the maximum jumps from a given index
    private int helper(int[] arr, int d, int index, int[] dp) {
        // If we have already computed the result for this index, return it
        if (dp[index] > 0) {
            return dp[index];
        }

        int result = 1;

        // Explore jumps to the left
        for (int i = index - 1; i >= Math.max(index - d, 0) && arr[index] > arr[i]; i--) {
            result = Math.max(result, 1 + helper(arr, d, i, dp));
        }

        // Explore jumps to the right
        for (int i = index + 1; i <= Math.min(index + d, arr.length - 1) && arr[index] > arr[i]; i++) {
            result = Math.max(result, 1 + helper(arr, d, i, dp));
        }

        // Store the result in dp array
        dp[index] = result;

        return result;
    }
}
