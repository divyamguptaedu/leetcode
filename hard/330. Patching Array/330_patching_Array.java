"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Patching Array.
Memory Usage: 38.4 MB, less than 89.15% of Java online submissions for Patching Array.

"""

class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum >= n) {
                return count;
            }
            while (sum < n && nums[i] > sum + 1) {
                count++;
                sum = (sum << 1) + 1;
            }
            sum += nums[i];
        }
        while (sum < n) {
            count++;
            sum = (sum <<1 ) + 1;
        }
        return count;
    }
}