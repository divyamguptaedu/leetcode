//I iterated through the array with a pointer 'anchor' marking the start of the current
//increasing subsequence. As I traversed the array, 
//I compared each element with the previous one. 
//If an element was not greater than the previous, 
//I updated anchor to the current position. 
//I continuously tracked the maximum length of increasing subsequence encountered so far.

//Time: O(n)
//Space: O(1)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                anchor = i;
            }
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
}