"""
Performance:
Runtime: 362 ms, faster than 11.39% of Java online submissions for Perfect Squares.
Memory Usage: 72 MB, less than 5.73% of Java online submissions for Perfect Squares.
"""

class Solution {

    public int numSquares(int n) {
        return helper(n, new HashMap<>());
    }
    
    private int helper(int n, Map<Integer, Integer> valueMap) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // if n is a perfect square, return 1;
        int root = (int) Math.sqrt(n);
        if (root * root == n) {
            return 1;
        }
        
        // if already calculated, return value from map;
        Integer result = valueMap.get(n);
        if (result != null) {
            return result;
        }
        
        result = Integer.MAX_VALUE;

        // start from 1 and choose minimum for the result;
        for (int i = 1; i <= root; i++) {
            int square = i * i;
            int temp = helper(n - square, valueMap) + 1;
            result = Math.min(result, temp);
        }
        
        // add in map for optimization;
        valueMap.put(n, result);

        return result; 
    }
}
