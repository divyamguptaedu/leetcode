"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
Memory Usage: 36.6 MB, less than 18.35% of Java online submissions for House Robber.
"""

class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int notRob = 0;
        for (int i = 0; i < nums.length; i++) {
        	int current = notRob + nums[i];
        	notRob = Math.max(notRob, rob);
        	rob = current;
        }
        return Math.max(notRob, rob);
    }
}