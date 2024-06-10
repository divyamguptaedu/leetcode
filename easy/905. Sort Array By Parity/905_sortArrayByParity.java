//I used a two-pointer approach to sort an array by parity. 
//Starting with pointers at the beginning and end of the array, 
//I moved the left pointer forward if it pointed to an even number and 
//the right pointer backward if it pointed to an odd number. 
//When the left pointer found an odd number and the right pointer found an even number, 
//I swapped them. This ensured that all even numbers were moved to the beginning of the array, 
//followed by all odd numbers.

//Time: n
//Space: constant
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0; // Pointer starting from the beginning
        int right = nums.length - 1; // Pointer starting from the end

        while (left < right) {
            // Swap if left points to an odd number and right points to an even number
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            // Move left pointer forward if it's pointing to an even number
            if (nums[left] % 2 == 0) {
                left++;
            }

            // Move right pointer backward if it's pointing to an odd number
            if (nums[right] % 2 == 1) {
                right--;
            }
        }

        return nums; // Return the sorted array
    }
}