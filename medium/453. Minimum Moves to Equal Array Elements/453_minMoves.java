"""
Performance:
Runtime: 18 ms, faster than 10.23% of Java online submissions for Minimum Moves to Equal Array Elements.
Memory Usage: 53.9 MB, less than 60.64% of Java online submissions for Minimum Moves to Equal Array Elements.
"""

class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length - 1;
        int count = 0;
        while (size > 0) {
        int difference = nums[size] - nums[0];
            count += difference;
            size--;
        }
        return count;
    }
}