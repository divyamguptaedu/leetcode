//I used backtracking to solve the Permutations II problem. I sorted the input array to handle duplicates easily.
//I created a recursive function to build permutations. 
//At each step, I checked if the current number had been used or was a duplicate of the previous number 
//(ensuring the previous duplicate had been used). If not, I marked the number as used, added it to the current permutation, 
//and called the function recursively. When the permutation was complete, I added it to the result list. 
//After exploring, I backtracked by unmarking the number and removing it from the current permutation.

//Time: O(n*n!) where n is the number of elements in the input array
//Space: O(n) if we dont consider the result space. If we do, then O(n*n!)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // List to store the result of all unique permutations
        List<List<Integer>> list = new ArrayList<>();
        // Sort the array to handle duplicates
        Arrays.sort(nums);
        // Start backtracking with an empty list and a boolean array to mark used elements
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        // If the temporary list is the same size as nums, we have a complete permutation
        if (tempList.size() == nums.length) {
            // Add a copy of the current permutation to the result list
            list.add(new ArrayList<>(tempList));
        } else {
            // Iterate over all elements in nums
            for (int i = 0; i < nums.length; i++) {
                // Skip the element if it is already used or if it is a duplicate and the previous duplicate was not used
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                    continue;
                // Mark the element as used
                used[i] = true;
                // Add the element to the current permutation
                tempList.add(nums[i]);
                // Recursively build the permutation with the next elements
                backtrack(list, tempList, nums, used);
                // Backtrack by removing the element and marking it as unused
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
