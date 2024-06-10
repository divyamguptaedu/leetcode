//I determined if an array was monotonic by checking if it was either entirely
//non-increasing or non-decreasing. I used two boolean variables, increasing and decreasing, 
//initially set to true. As I iterated through the array, I updated these variables based on
//the comparisons of adjacent elements. 
//If any element violated the conditions for monotonicity, 
//I set the corresponding variable to false. 
//At the end, I returned true if the array was either entirely non-increasing or
//non-decreasing.

//Time: n
//Space: constant
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true; // Track if array is non-decreasing
        boolean isDecreasing = true; // Track if array is non-increasing

        // Iterate through the array
        for (int i = 0; i < nums.length - 1; ++i) {
            // If current element is greater than the next, it's not non-decreasing
            if (nums[i] > nums[i + 1]) {
                isIncreasing = false;
            }
            // If current element is less than the next, it's not non-increasing
            if (nums[i] < nums[i + 1]) {
                isDecreasing = false;
            }
        }

        // Array is monotonic if it is either non-decreasing or non-increasing
        return isIncreasing || isDecreasing;
    }
}
