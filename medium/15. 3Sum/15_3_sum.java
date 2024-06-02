//We can reuse the hashset approach from the 2sum problem to solve this question.
//I sorted the array and iterated through it. For each element, I used a hash set to 
//find pairs that sum up to the negative value of the current element. 
//This approach avoided duplicates by skipping repeated values. 
//By checking if the complement of the current pair exists in the hash set, 
//I identified valid triplets. If a triplet was found, I added it to the result list and 
//skipped over any duplicates.

//Time: O(n^2) : TwoSum approach was linear, but we call it n times, so makes n^2. Sorting is nlogn.
//Space: O(n)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to make it easier to avoid duplicates and use a hash set
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            // Skip duplicate elements to avoid duplicate triplets in the result
            if (i == 0 || nums[i - 1] != nums[i]) {
                // Use a hash set to find pairs that sum up to -nums[i]
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            
            // If the complement is in the set, we found a valid triplet
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                // Skip duplicate elements to avoid duplicate triplets in the result
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) ++j;
            }
            // Add the current element to the set
            seen.add(nums[j]);
        }
    }
}

//Followup, if we can't sort the array then,
//I used two sets, res to store unique triplets and dups to avoid processing duplicate elements. 
//For each element in the array, I checked pairs of elements that sum up to the negative value 
//of the current element using a hash map seen to store indices. 
//If a valid triplet was found, I sorted it and added it to res to avoid duplicates.

//Time: O(n^2)
//Space: O(n)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            // Add element to dups set and check for duplicates
            if (dups.add(nums[i])) {
                // Iterate through the array to find pairs
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    
                    // Check if the complement is in the seen map and if it matches the current i index
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        // Create a triplet and add it to the result set
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    // Put the current element and its index into the seen map
                    seen.put(nums[j], i);
                }
            }
        }
        // Convert the set of triplets to a list
        return new ArrayList<>(res);
    }
}