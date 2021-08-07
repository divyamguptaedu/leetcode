"""
Performance:
Runtime: 143 ms, faster than 5.15% of Java online submissions for Top K Frequent Elements.
Memory Usage: 48.4 MB, less than 5.11% of Java online submissions for Top K Frequent Elements.
"""

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    	HashMap<Integer, Integer> valueMap = new HashMap<>();
    	for (int x : nums) {
    		if (valueMap.get(x) == null) {
    			valueMap.put(x, 1);
    		} else {
    			valueMap.put(x, valueMap.get(x) + 1);
    		}
    	}
    	int[] result = new int[k];
    	for (int i = 0; i < k; i++) {
    		result[i] = removeMaximum(valueMap);
    	}
    	return result;
    }

    private int removeMaximum(HashMap<Integer, Integer> valueMap) {
    	int maxKey = 0;
    	int maxValue = 0;
    	for (Integer key: valueMap.keySet()) {
    		if (valueMap.get(key) > maxValue) {
    			maxValue = valueMap.get(key);
    			maxKey = key;
    		}
    	}
    	valueMap.remove(maxKey);
    	return maxKey;
    }
}