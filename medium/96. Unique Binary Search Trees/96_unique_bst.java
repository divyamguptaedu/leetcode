"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
Memory Usage: 35.7 MB, less than 65.76% of Java online submissions for Unique Binary Search Trees.
"""

class Solution {
    public int numTrees(int n) {

    	if (n == 1) {
    		return 1;
    	}
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = helper(n, hashMap);
        return sum;

    }

    private int helper(int n, HashMap<Integer, Integer> hashMap) {

    	if (n == 0 || n == 1) {
    		return 1;
    	}

    	if (hashMap.get(n) != null) {
    		return hashMap.get(n);
    	}

    	int count = 0;

    	for (int i = 1; i <= n; i++) {
    		count = count + (helper(i - 1, hashMap) * helper(n - i, hashMap));
    	}

    	hashMap.put(n, count);
    	return hashMap.get(n);

    }
}