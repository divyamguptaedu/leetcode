"
Performance:
Runtime: 3 ms, faster than 54.26% of Java online submissions for Global and Local Inversions.
Memory Usage: 79 MB, less than 39.46% of Java online submissions for Global and Local Inversions.
"

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0 ; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}