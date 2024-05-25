//I used a hash map to store lists of indices for each number in the array. 
//During initialization, I iterated through the array and populated the map with indices of each number. 
//For the pick method, I retrieved the list of indices for the target number from the map and used a 
//random number generator to select one of these indices. 
//This ensured each index had an equal probability of being chosen.

//Time: O(n) where n is the length of nums
//Space: O(n)
class Solution {
    Map<Integer, List<Integer>> indices = new HashMap<>();

    // Constructor to initialize the object with the array nums
    public Solution(int[] nums) {
        // Populate the map with lists of indices for each number in nums
        for (int i = 0; i < nums.length; i++) {
            // If the number is not yet in the map, add it with an empty list
            if (!indices.containsKey(nums[i])) {
                indices.put(nums[i], new ArrayList<>());
            }
            // Add the current index to the list for this number
            indices.get(nums[i]).add(i);
        }
    }

    // Method to pick a random index for the given target
    public int pick(int target) {
        Random random = new Random(); // Create a random number generator

        // Check if the target exists in the map
        if (indices.containsKey(target)) {
            // Get the list of indices for the target number
            List<Integer> targetIndices = indices.get(target);
            // Generate a random index within the list of indices
            int randomIndex = random.nextInt(targetIndices.size());
            // Return the index at the random position
            return targetIndices.get(randomIndex);
        }

        return -1; // If the target is not found, return -1
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
