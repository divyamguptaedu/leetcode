"
Performance:
Runtime: 2 ms, faster than 60.26% of Java online submissions for Combination Sum IV.
Memory Usage: 41.5 MB, less than 48.76% of Java online submissions for Combination Sum IV.
"

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] result = new int[target + 1];
        result[0] = 1;
        for (int i = 1; i <= target ; i++) {
            for (int x : nums) { 
                if (i >= x) {
                    result[i] += result[i - x];
                }
            }
        }
        return result[target];
    }
}