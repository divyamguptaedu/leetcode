/*
Increase nums[i] by the previous index's running sum. The previous index's running sum is stored at index i-1 in the input array.
We repeat step 1 for all indices from 1 to n-1.

Time: n
Space: constant
*/
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}