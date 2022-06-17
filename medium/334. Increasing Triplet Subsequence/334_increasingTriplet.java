"
Performance:
Runtime: 4 ms, faster than 36.85% of Java online submissions for Increasing Triplet Subsequence.
Memory Usage: 92.4 MB, less than 68.15% of Java online submissions for Increasing Triplet Subsequence.
"

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int tempOne = Integer.MAX_VALUE;
        int tempTwo = Integer.MAX_VALUE;

        for (int num: nums) {
            if (num <= tempOne) {
                tempOne = num;
            } else if (num <= tempTwo) {
                tempTwo = num;
            } else {
                return true;
            }
        }
        return false;
    }
}