//I iterated through the array once to place each positive integer in its correct position,
//assuming a perfect array where nums[i] == i + 1. 
//If an element is out of range or duplicates an existing element's position, I continue. 
//Then, I iterated again to find the first mismatch between the value at index j and j + 1, 
//which would be the smallest missing positive integer. 
//If no mismatches are found, the missing positive is the length of the array plus one. 
//This approach guarantees linear time complexity and constant space complexity.

//Time: n
//Space: constant
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        // Iterate through the array to place each positive integer in its correct position.
        while (i < nums.length) {
            int correct = nums[i] - 1; // The correct index for the current number.
            // If the current number is in range and not in its correct position, swap it.
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++; // Move to the next element.
            }
        }

        // Iterate through the array to find the first mismatch between value and index + 1.
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1; // The smallest missing positive integer.
            }
        }
        return nums.length + 1; // If all positive integers from 1 to n are present.
    }

    // Method to swap elements in the array.
    private void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}