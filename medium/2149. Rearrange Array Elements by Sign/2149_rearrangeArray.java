//To rearrange the array elements so that every consecutive pair of integers has opposite signs, 
//I used a two-pointer approach. I created a new array to store the result. 
//One pointer tracked the position for positive integers, starting at index 0, and another tracked the 
//position for negative integers, starting at index 1. As I iterated through the original array, 
//I placed positive integers at the positive pointer and incremented it by 2, and negative integers 
//at the negative pointer and incremented it by 2. This ensured that the positive and negative integers 
//alternated correctly.
//Time: n
//Space: n
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Initializing an answer array of size n
        int[] ans = new int[n];

        // Initializing two pointers to track even and
        // odd indices for positive and negative integers respectively
        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // Placing the positive integer at the
                // desired index in ans and incrementing posIndex by 2
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                // Placing the negative integer at the
                // desired index in ans and incrementing negIndex by 2
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }
}