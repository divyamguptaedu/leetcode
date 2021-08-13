"""
Performance: 
Runtime: 26 ms, faster than 55.77% of Java online submissions for Target Sum.
Memory Usage: 51.1 MB, less than 5.12% of Java online submissions for Target Sum.
"""

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    
        int origin = 1000;
        int store[][] = new int[nums.length + 1][2001];

        // store answers to increase runtime;
        store[0][origin + 0] = 1;
        
        for (int i = 1; i < store.length; i++) {
            for (int j = 0; j < store[0].length; j++) {
                if (store[i - 1][j] > 0) {
                    // store both increasing and decreasing sum;
                    store[i][j + nums[i - 1]] += store[i - 1][j];
                    store[i][j - nums[i - 1]] += store[i - 1][j];
                }
            }
        }
        return store[nums.length][origin + target];
    }
}