//I initialized three pointers: zeroPointer for the next position of 0, 
//currentPointer for the current element, and twoPointer for the next position of 2. 
//I iterated through the array, swapping elements to ensure that all 0s were moved to the 
//front and all 2s to the back. If the current element was 0, I swapped it with the element at 
//zeroPointer and moved both zeroPointer and currentPointer forward. If it was 2, 
//I swapped it with the element at twoPointer and moved twoPointer backward. 
//If it was 1, I just moved currentPointer forward.

//Time: n
//Space: constant
class Solution {
    public void sortColors(int[] nums) {
        int zeroPointer = 0;
        int currentPointer = 0;
        int twoPointer = nums.length - 1;

        int temp;
        while (currentPointer <= twoPointer) {
            if (nums[currentPointer] == 0) {
                // Swap zeroPointer-th and currentPointer-th elements
                temp = nums[zeroPointer];
                nums[zeroPointer++] = nums[currentPointer];
                nums[currentPointer++] = temp;
            } else if (nums[currentPointer] == 2) {
                // Swap twoPointer-th and currentPointer-th elements
                temp = nums[currentPointer];
                nums[currentPointer] = nums[twoPointer];
                nums[twoPointer--] = temp;
            } else {
                currentPointer++;
            }
        }
    }
}