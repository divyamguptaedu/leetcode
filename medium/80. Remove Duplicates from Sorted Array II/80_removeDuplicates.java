//I tackled the problem of removing duplicates from a sorted array such that each unique element 
//appears at most twice. Using two pointers, i and j, 
//I iterated through the array starting from the second element. 
//j tracks where the next valid position for an element should be placed in the modified array. 
//Meanwhile, count keeps track of how many times the current element has appeared consecutively. 
//If an element appears less than or equal to twice (count <= 2), it is copied to the j-th position, 
//otherwise, it is skipped. Finally, j returns the length of the modified array.

//Time: n
//Space: constant
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1; // Pointer to place the next valid element
        int count = 1; // Counter for consecutive occurrences
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++; // Increment count for consecutive duplicates
            } else {
                count = 1; // Reset count for new unique element
            }
            
            if (count <= 2) {
                nums[j++] = nums[i]; // Copy the element to the next valid position
            }
        }
        
        return j; // Return the length of the modified array
    }
}