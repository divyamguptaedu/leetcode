//Initialize two pointers, left and i, and a variable sum to track the current subarray's sum.
//Iterate through the array, expanding the window by adding elements to sum.
//Whenever sum exceeds or equals the target, shrink the window from the left until sum is less than the target.
//Update the minimal length of the subarray (ans) if a new minimum is found during each iteration.
//Return the minimal length of the subarray found, or 0 if no such subarray exists.

//Time: O(n) n is the length of the array nums.
//Space: O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Get the length of the array
        int n = nums.length;
        // Initialize ans to the maximum possible value
        int ans = Integer.MAX_VALUE;
        // Initialize left pointer to 0
        int left = 0;
        // Initialize sum to 0
        int sum = 0;
        // Loop through the array
        for (int i = 0; i < n; i++) {
            // Add the current element to the sum
            sum += nums[i];
            // While the sum is greater than or equal to the target
            while (sum >= target) {
                // Update ans to the minimum of its current value and the difference between current index and left pointer + 1
                ans = Math.min(ans, i + 1 - left);
                // Subtract the leftmost element from the sum and move the left pointer to the right
                sum -= nums[left++];
            }
        }
        // If ans was updated, return ans, otherwise return 0
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
