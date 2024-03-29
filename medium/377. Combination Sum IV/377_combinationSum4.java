class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return helper(nums, target, dp);
    }
    
    public int helper(int[] nums, int remain, Integer[] dp){
        
        if (remain < 0) {
            return 0;
        }
        if (dp[remain] != null) {
            return dp[remain];
        }
        if (remain == 0) {
            return 1;
        }
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            ans += helper(nums, remain - nums[i], dp);
        }
        
        dp[remain] = ans;
        return dp[remain];
    }
}