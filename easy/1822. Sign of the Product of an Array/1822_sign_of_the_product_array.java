"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Sign of the Product of an Array.
Memory Usage: 38.3 MB, less than 93.72% of Java online submissions for Sign of the Product of an Array.
"""

class Solution {
    public int arraySign(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                count *= -1;
            } else if (nums[i] == 0)
                return 0;
        }
        return count;
    }
}