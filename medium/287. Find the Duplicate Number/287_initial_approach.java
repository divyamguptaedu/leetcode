"""
Performance:
Runtime: 22 ms, faster than 29.60% of Java online submissions for Find the Duplicate Number.
Memory Usage: 52 MB, less than 89.93% of Java online submissions for Find the Duplicate Number.
"""

class Solution {
    public int findDuplicate(int[] nums) {

        // add all x in nums to a hashmap and return if already added.
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int x : nums) {
        	if (hashMap.get(x) == null) {
        		hashMap.put(x, true);
        	} else {
        		return x;
        	}
        }
        return -1;
    }
}