//I iterate through the sorted array, skipping duplicates. 
//If the current element is different from the previous one, 
//I store it at the next available index in the array, 
//effectively removing duplicates in-place. 
//I maintain an insert index to track the position of the next unique element. 
//Finally, I return the count of unique elements, which is equivalent to the insert index.

//Time: n
//Space: constant
class Solution {
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1; // Index to store the next unique element
        for (int i = 1; i < nums.length; i++) {
            // Skip duplicates
            if (nums[i - 1] != nums[i]) {
                // Store the unique element at insertIndex and increment it
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex; // Return count of unique elements
    }
}