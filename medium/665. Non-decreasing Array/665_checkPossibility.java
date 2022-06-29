"
Performance:
Runtime: 1 ms, faster than 96.24% of Java online submissions for Non-decreasing Array.
Memory Usage: 43.3 MB, less than 97.10% of Java online submissions for Non-decreasing Array.
"

class Solution {
    public boolean checkPossibility(int[] nums) {
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (temp++ > 0) {
                    return false;
                }
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i]; 
                } else {
                    nums[i] = nums[i - 1]; 
                }
            }
        }
        return true;
    }
}