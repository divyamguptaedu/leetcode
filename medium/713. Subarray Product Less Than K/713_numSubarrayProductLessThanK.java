//Check constraints.
//To solve this question, we can use the sliding window approach. First we can handle the edge cases 
//such as when k is 0 or 1. In contraints we have positive numbers only.
//Now, we will keep a totalCount and a product variable. We will use two pointers for sliding window.
//We will expand the window by including the element at the right pointer. 
//Now if it exceeds the k, then we shrink the window from the left by dividing.
//For every valid subarray we keep on adding its size to the total count.
//Adding the size to the total count helps us keep track of the individual smaller subarrays we are missing.
//Dry run to help better understand the adding the size to the count part.

//Time: O(n)
//Space: O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Handle edge cases where k is 0 or 1 (no subarrays possible)
        // Because in the contraints we know the nums can be numbers between 1 and 1000.
        if (k <= 1) return 0;

        int totalCount = 0;
        int product = 1;

        // Use two pointers to maintain a sliding window
        for (int left = 0, right = 0; right < nums.length; right++) {
            // Expand the window by including the element at the right pointer
            product *= nums[right];

            // Shrink the window from the left while the product is greater than or equal to k
            while (product >= k) {
                // Remove the element at the left pointer from the product
                product /= nums[left++];
            }

            // Update the total count by adding the number of valid subarrays with the current window size
            totalCount += right - left + 1;  // right - left + 1 represents the current window size
            // The above line accounts for all the individual subarrays too. Dry run to understand.
        }

        return totalCount;
    }
}