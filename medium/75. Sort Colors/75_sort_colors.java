"""
Performance:
Runtime: 1 ms, faster than 13.83% of Java online submissions for Sort Colors.
Memory Usage: 38 MB, less than 11.79% of Java online submissions for Sort Colors.

"""

class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        for (int x : nums) {
        	if (valueMap.get(x) == null) {
        		valueMap.put(x, 1);
        	} else {
        		valueMap.put(x, valueMap.get(x) + 1);
        	}
        }
        PriorityQueue<Integer> keys = new PriorityQueue<>();
        for (int x : valueMap.keySet()) {
        	keys.add(x);
        }
        int i = 0;
        int key;
        while (!keys.isEmpty()) {
        	key = keys.poll();
        	for (int j = 0; j < valueMap.get(key); j++) {
        		nums[i] = key;
        		i++;
        	}
        }
    }
}