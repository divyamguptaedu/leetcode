"
Performance:
Runtime: 11 ms, faster than 67.31% of Java online submissions for Smallest Range II.
Memory Usage: 48.9 MB, less than 80.00% of Java online submissions for Smallest Range II.
"

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int size = nums.length;
        int result = nums[size - 1] - nums[0];
        int minimum = nums[0] + k;
        int maximum = nums[size - 1] - k;
        for (int i = 0; i < size - 1; i++) {      
            int temp = Math.max(maximum, nums[i] + k);
        int tempTwo = Math.min(minimum, nums[i+1] - k);
            result = Math.min(result, temp - tempTwo);
        }
        return result;
    }
}