"""
Performance:
Runtime: 1 ms, faster than 100.00% of Java online submissions for Check If It Is a Good Array.
Memory Usage: 49 MB, less than 52.08% of Java online submissions for Check If It Is a Good Array.
"""

class Solution {
    
    public boolean isGoodArray(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] != 1) {
                return false;
            } else {
                return true;
            }
        }
        int answer = helper(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            answer = helper(answer,nums[i]);
        }
        if (answer == 1) {
            return true;
        }
        return false;
    }
    
    private int helper(int a, int b){
        if (a == 0) {
            return b;
        }
        return helper(b % a, a);
    }
}