//I used a hashmap to find two numbers in the array that add up to the target.
//For each number in the array, I calculated its complement
//(the number needed to reach the target when added to the current number). 
//I checked if this complement existed in the hashmap.
//If it did, I returned the indices of the current number and its complement.
//If not, I stored the current number and its index in the hashmap for
//future reference.

//Time: n
//Space: n
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the value and its index
        Map<Integer, Integer> numToIndex = new HashMap<>();

        // Iterate over each number in the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the complement

            // Check if the complement exists in the hashmap
            if (numToIndex.containsKey(complement)) {
                // If found, return the indices of the complement and the current number
                return new int[] { numToIndex.get(complement), i };
            }

            // Store the current number and its index in the hashmap
            numToIndex.put(nums[i], i);
        }

        // In case no solution is found, return null
        return null;
    }
}