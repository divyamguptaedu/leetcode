//I iterated through the array while maintaining the cumulative sum modulo k. 
//I used a set to track previously seen cumulative sum moduli. 
//For each element, I updated the cumulative sum and checked if the current sum modulo k was already in the set, 
//indicating a subarray sum that is a multiple of k. 
//I added the previous cumulative sum modulo k to the set before moving to the next element. 
//If I found a match, I returned true; otherwise, I returned false at the end.

//Time: O(n) where n is the length of nums
//Space: O(min(n, k))

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> modSet = new HashSet<>(); // Set to store previously seen mod values
        int currSum = 0, prevSum = 0; // Initialize current and previous cumulative sums

        // Iterate through the array
        for (int n : nums) {
            currSum += n; // Update the cumulative sum with the current element
            // Check if the current cumulative sum modulo k has been seen before
            if (modSet.contains(currSum % k)) {
                return true; // Found a subarray sum that is a multiple of k
            }
            currSum %= k; // Update the current sum modulo k
            modSet.add(prevSum); // Add the previous sum modulo k to the set
            prevSum = currSum; // Update the previous sum for the next iteration
        }
        return false; // No valid subarray found
    }
}