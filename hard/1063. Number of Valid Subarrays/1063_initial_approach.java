"
Performance:
Runtime: 74 ms, faster than 5.95% of Java online submissions for Number of Valid Subarrays.
Memory Usage: 62.8 MB, less than 13.09% of Java online submissions for Number of Valid Subarrays.
"

class Solution {
    public int validSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0;i < nums.length; i++) {
            for (int j = i; j < nums.length && nums[i] <= nums[j]; j++) {
                count++;
            }
        }
        return count;
    }
}