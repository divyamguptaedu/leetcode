//I located the first decreasing element from the end of the array. 
//If found, I searched for the smallest element larger than it to its right and 
//swapped them. Then, I reversed the array segment to the right of the originally 
//found position to get the next permutation. If no decreasing element was found, 
//I reversed the entire array to get the smallest permutation.

//Time: O(n)
//Space: O(1)
public class Solution {
    public void nextPermutation(int[] nums) {
        // Find the first decreasing element from the end
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // If found, find the smallest element larger than nums[i] to its right and swap them
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // Reverse the array segment to the right of the original position of nums[i]
        reverse(nums, i + 1);
    }

    // Reverse the elements of the array from the start index to the end
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    // Swap the elements at index i and j in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}