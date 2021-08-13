"""
Performance:
Runtime: 18 ms, faster than 68.98% of Java online submissions for Subarray Sum Equals K.
Memory Usage: 41.5 MB, less than 46.46% of Java online submissions for Subarray Sum Equals K.
"""

public class Solution {
    public int subarraySum(int[] nums, int k) {
    	int count = 0;
    	int sum = 0;
    	HashMap<Integer, Integer> valueMap = new HashMap<>();
    	valueMap.put(0, 1);
    	for (int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    		if (valueMap.containsKey(sum - k)) {
    			count += valueMap.get(sum - k);
    		}
    		valueMap.put(sum, valueMap.getOrDefault(sum, 0) + 1);
    	}
    	return count;
    }
}