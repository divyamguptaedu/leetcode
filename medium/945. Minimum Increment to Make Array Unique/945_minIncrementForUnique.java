"
Performance:
Runtime: 44 ms, faster than 80.37% of Java online submissions for Minimum Increment to Make Array Unique.
Memory Usage: 79.1 MB, less than 26.51% of Java online submissions for Minimum Increment to Make Array Unique.
"

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int seen = Integer.MIN_VALUE;
        int result = 0;
        for (int i : nums) {
            if (i <= seen) {
                result = result + (seen - i + 1);
                seen++;
            } else {
                seen = i;
            }
        }
        return result;
    }
}