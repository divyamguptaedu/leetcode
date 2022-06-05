"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Wiggle Subsequence.
Memory Usage: 39.8 MB, less than 86.79% of Java online submissions for Wiggle Subsequence.
"

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int size = nums.length;
        int positive = 1;
        int negative = 1;
        for (int i = 1; i < size; i++) {
            if (nums[i] > nums[i-1]) {
                positive = negative+1;
            } else if (nums[i]<nums[i-1]) {
                negative = positive+1;
            }
        }
        return Math.max(positive, negative);
    }
}