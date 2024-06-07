//I kept track of the prefix sum while iterating through the array. 
//I used a hashmap to store the first occurrence of each prefix sum. 
//When the prefix sum equaled k, I updated the result to the current length. 
//If the hashmap contained the difference between the prefix sum and k, 
//I updated the result with the maximum length found. 
//Finally, I added the prefix sum to the hashmap if it wasn't already present.

//Time: n
//Space: n
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixSumIndices = new HashMap<>(); // HashMap to store the first occurrence of each prefix sum
        int prefixSum = 0; // Initialize the prefix sum
        int maxLength = Integer.MIN_VALUE; // Initialize the maximum length of subarray

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i]; // Update the prefix sum

            // Check if the current prefix sum is equal to k
            if (prefixSum == k) {
                maxLength = i + 1; // Update the maximum length of subarray
            }

            // Check if there is a subarray that sums to k
            if (prefixSumIndices.containsKey(prefixSum - k)) {
                // Calculate the subarray length and update maxLength
                maxLength = Math.max(maxLength, i - prefixSumIndices.get(prefixSum - k));
            }

            // Store the first occurrence of the prefix sum if it's not already present
            if (!prefixSumIndices.containsKey(prefixSum)) {
                prefixSumIndices.put(prefixSum, i);
            }
        }

        // Return the maximum length found, or 0 if no subarray sums to k
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}