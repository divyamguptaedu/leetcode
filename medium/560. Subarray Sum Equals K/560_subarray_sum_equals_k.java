//I used a hash map to keep track of the cumulative sum up to each index and the frequency of these sums.
//As I iterated through the array, I maintained a running sum. 
//For each element, I checked if the difference between the running sum and k existed in the hash map. 
//If it did, it meant there was a subarray ending at the current index that summed to k, 
//so I added the frequency of that sum to the count. 
//I then updated the hash map with the current running sum.

//Time: O(n)
//Space: O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;  // Initialize the count of subarrays
        int sum = 0;  // Initialize the running sum
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // Initialize the map with sum 0 occurring once

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];  // Update the running sum
            if (map.containsKey(sum - k))  // Check if the (sum - k) exists in the map
                count += map.get(sum - k);  // If it does, add the frequency to count
            map.put(sum, map.getOrDefault(sum, 0) + 1);  // Update the map with the current sum
        }
        return count;  // Return the total count of subarrays
    }
}
