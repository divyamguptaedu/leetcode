//I iterated through the array while keeping track of the previous significant value (left).
//For each element, I checked if it was a hill or valley by comparing it with its neighbors.
//If it was a hill (greater than both neighbors) or a valley (less than both neighbors), 
//I incremented the count and updated the left value. This ensured that only valid hills 
//and valleys were counted.

//Time: O(n)
//Space: O(1)
class Solution {
    public int countHillValley(int[] nums) {
        // Initialize left as the first element of the array
        int left = nums[0];
        // Initialize count to store the number of hills and valleys
        int count = 0;

        // Iterate through the array from the second element to the second last element
        for (int i = 1; i < nums.length - 1; i++) {
            // Check if current element is part of a hill or valley
            if ((left < nums[i] && nums[i] > nums[i + 1]) || 
                (left > nums[i] && nums[i] < nums[i + 1])) {
                // Increment the count if it is
                count++;
                // Update left to current element
                left = nums[i];
            }
        }
        // Return the total count of hills and valleys
        return count;
    }
}