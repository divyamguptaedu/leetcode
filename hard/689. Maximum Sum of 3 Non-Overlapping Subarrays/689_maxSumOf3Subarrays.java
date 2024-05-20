//I first calculated the sum of all possible subarrays of length k and stored these sums in an array W. 
//Then, I used dynamic programming to find the leftmost and rightmost maximum subarray sums for any given subarray in W. 
//Specifically, for each possible middle subarray, 
//I identified the best subarray to its left and right using the precomputed arrays of maximum sums. 
//Finally, I iterated through possible middle subarrays to find the combination that maximized the total sum, 
//returning their starting indices.

//Time: O(n)
//Space: O(n)
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // W is an array of sums of windows
        int[] W = new int[nums.length - k + 1];
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (i >= k) {
                currSum -= nums[i - k];
            }
            if (i >= k - 1) {
                W[i - k + 1] = currSum;
            }
        }

        int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] >= W[best]) {
                best = i;
            }
            right[i] = best;
        }
        
        int[] ans = new int[]{-1, -1, -1};
        for (int j = k; j < W.length - k; j++) {
            int i = left[j - k], l = right[j + k];
            if (ans[0] == -1 || W[i] + W[j] + W[l] > W[ans[0]] + W[ans[1]] + W[ans[2]]) {
                ans[0] = i;
                ans[1] = j;
                ans[2] = l;
            }
        }
        return ans;
    }
}