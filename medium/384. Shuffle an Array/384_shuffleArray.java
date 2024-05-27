//I initialized the array in the constructor, saved the original configuration, and 
//created methods to reset the array to its original state and shuffle it randomly. 
//In the shuffle method, I iterated over the array and swapped each element with a 
//randomly chosen element from the remaining ones. This way, I ensured that all 
//permutations of the array are equally likely. Resetting simply returns the saved original array. 
//The shuffling algorithm randomly selects elements to swap, ensuring uniform distribution.

//Time: Constructor takes O(n), reset - O(1), shuffle - O(n)
//Space: O(n)

class Solution {
    public int[] nums; // Original array
    public int[] saved; // Saved original array

    public Solution(int[] nums) {
        this.nums = nums; // Initialize original array
        saved = Arrays.copyOf(nums, nums.length); // Save a copy of the original array
    }

    public int[] reset() {
        return saved; // Return the saved original array
    }

    public int[] shuffle() {
        for (int i = nums.length - 1; i > 1; --i) { // Iterate over the array from the end
            int j = (int) (Math.random() * (i + 1)); // Generate a random index within the array
            int temp = nums[i]; // Swap current element with a randomly chosen element
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums; // Return the shuffled array
    }
}