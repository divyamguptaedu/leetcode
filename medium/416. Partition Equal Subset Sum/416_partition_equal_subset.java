"""
Performance:
Runtime: 41 ms, faster than 46.08% of Java online submissions for Partition Equal Subset Sum.
Memory Usage: 38.8 MB, less than 78.50% of Java online submissions for Partition Equal Subset Sum.
"""

class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum & 1) == 1)
            return false;
        sum = sum >> 1;

        boolean[] store = new boolean[sum+1];

        store[0] = true;

        for(int i = 1; i <= nums.length; i++){
            for(int j = sum; j >= 1; j--){
                
                if(j - nums[i - 1] >= 0)
                    store[j] = store[j] || store[j - nums[i-1]];
            }
        }
        return store[sum];        
    }
}