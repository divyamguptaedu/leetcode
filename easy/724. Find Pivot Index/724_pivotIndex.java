// I first calculate the total sum of all elements in the array.
//Then, I iterate through the array, keeping track of the left sum. 
//At each index, I check if the left sum equals the total sum minus the left sum minus
//the current element. If so, I return the index. If no such index is found, I return -1.

//Time: n
//Space: 1
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        
        // Calculate total sum of all elements in the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // Iterate through the array to find pivot index
        for (int i = 0; i < nums.length; ++i) {
            // Check if left sum equals the sum of elements to the right
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i; // Return the pivot index
            }
            leftSum += nums[i]; // Update left sum
        }
        
        return -1; // Return -1 if no pivot index is found
    }
}
