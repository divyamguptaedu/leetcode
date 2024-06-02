//I iterated through the array with two pointers, i and j. 
//Pointer i traversed the array, and j kept track of the position to place the next 
//non-zero element. When I encountered a zero, I marked its position with j. 
//When a non-zero element was found, I swapped it with the element at j and incremented j. 
//This ensured that all zeros were moved to the end while maintaining the order of non-zero elements.

//Time: O(n)
//Space: O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = -1; // Pointer to track the position to place the next non-zero element

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && j == -1) {
                // Mark the first occurrence of zero
                j = i;
            } else if (nums[i] != 0 && j != -1) {
                // Swap the non-zero element with the element at position j
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }
}

//Reduce number of operations
//I iterated through the array with two pointers: lastNonZeroFoundAt to track the position 
//for the next non-zero element, and cur to traverse the array. 
//When I encountered a non-zero element, I swapped it with the element at lastNonZeroFoundAt 
//and incremented lastNonZeroFoundAt. This ensured all non-zero elements maintained their order, 
//and all zeroes were moved to the end.

public class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                // Swap the current element with the element at lastNonZeroFoundAt
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[cur];
                nums[cur] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }
}
