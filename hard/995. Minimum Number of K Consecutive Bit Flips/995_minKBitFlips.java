//I approached this problem by using a greedy algorithm to determine the minimum number of k-bit flips 
//required to make all elements in the array 1. I used two counters: 
//currentFlips to track the number of ongoing flips and totalFlips to count the total flips performed. 
//As I iterated through the array, I adjusted the currentFlips based on previous flips that had expired. 
//I flipped the current bit if necessary and marked it as flipped to manage the sliding window of size k.
//Time: n
//Space: constant
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int currentFlips = 0; // Tracks the current number of flips
        int totalFlips = 0; // Tracks the total number of flips

        for (int i = 0; i < nums.length; ++i) {
            // If the window slides out of the range and the leftmost element is
            // marked as flipped (2), decrement currentFlips
            if (i >= k && nums[i - k] == 2) {
                currentFlips--;
            }

            // Check if the current bit needs to be flipped
            if ((currentFlips % 2) == nums[i]) {
                // If flipping would exceed array bounds, return -1
                if (i + k > nums.length) {
                    return -1;
                }
                // Mark the current bit as flipped
                nums[i] = 2;
                currentFlips++;
                totalFlips++;
            }
        }

        return totalFlips;
    }
}