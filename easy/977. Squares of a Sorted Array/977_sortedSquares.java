//I squared each number in the array and then sorted the resulting squares. 
//To do this, I initialized an array to hold the squared values, 
//then used two pointers, one starting from the left end of the array and the other 
//from the right end. I iterated from the end of the result array and compared the 
//absolute values of the elements pointed by the two pointers. 
//Based on which absolute value was greater, I squared that number and stored it in the 
//result array. Finally, I returned the sorted array of squared values.

//Time: n
//Space: n
class Solution {
    public int[] sortedSquares(int[] nums) {
        // Initialize an array to hold the squared values
        int[] squaredArray = new int[nums.length];
        // Pointers for the left and right ends of the original array
        int leftPointer = 0; 
        int rightPointer = nums.length - 1;
        // Iterate through the squared array in reverse order
        for (int i = nums.length - 1; i >= 0; i--) {
            // Compare absolute values of elements pointed by left and right pointers
            if (Math.abs(nums[leftPointer]) >= Math.abs(nums[rightPointer])) {
                // Square and store the element pointed by the left pointer
                squaredArray[i] = nums[leftPointer] * nums[leftPointer];
                leftPointer++;
            } else {
                // Square and store the element pointed by the right pointer
                squaredArray[i] = nums[rightPointer] * nums[rightPointer];
                rightPointer--;
            }
        }
        // Return the sorted array of squared values
        return squaredArray; 
    }
}
