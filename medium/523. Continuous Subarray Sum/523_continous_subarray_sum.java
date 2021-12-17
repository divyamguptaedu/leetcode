"
Runtime: 46 ms, faster than 5.64% of Java online submissions for Continuous Subarray Sum.
Memory Usage: 128.2 MB, less than 5.02% of Java online submissions for Continuous Subarray Sum.
"

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {      
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k; 
            if (sum == 0 && i > 0) {
                return true;
            }
            if (map.containsKey(sum) && i - map.get(sum) > 1) { 
                return true;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i); 
            }
            
        }
        return false;
    }
}