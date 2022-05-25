"""
Performance:
Runtime: 15 ms, faster than 25.30% of Java online submissions for 3Sum Closest.
Memory Usage: 43.1 MB, less than 47.72% of Java online submissions for 3Sum Closest.
"""

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int initialSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int finalSum = nums[i] + nums[left] + nums[right];
                if (finalSum > target)
                    right--;
                else
                    left++;
                if (Math.abs(finalSum - target) < Math.abs(initialSum - target)) {
                    initialSum = finalSum;
                }
            }
        }
        return initialSum;
    }
}