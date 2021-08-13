"""
Performance: 
Runtime: 45 ms, faster than 27.65% of Java online submissions for Sliding Window Maximum.
Memory Usage: 132.9 MB, less than 5.20% of Java online submissions for Sliding Window Maximum.
"""

public class Solution {

    int[][] store;
    
    public int minDistance(String word1, String word2) {
		store = new int[word1.length()][word2.length()];
        return minDistanceHelper(word1, word2, 0, 0);
    }
    
    private int helper(String word1, String word2, int index1, int index2) {
        // check equality; 
        if (index1 == word1.length()) {
        	return word2.length() - index2;
        }
        if (index2 == word2.length()) {
        	return word1.length() - index1;
        }

        // use storage for optimization;
		if (store[index1][index2] > 0) {
			return store[index1][index2];
		}
        int result;

        if (word1.charAt(index1) == word2.charAt(index2)) {
            result = helper(word1, word2, index1 + 1, index2 + 1);
        } else {

            // choose minimum of result and result after recursion on new index;
            result = 1 + helper(word1, word2, index1 + 1, index2 + 1);
            result = Math.min(result, 1 + helper(word1, word2, index1 + 1, index2));
            result = Math.min(result, 1 + helper(word1, word2, index1, index2 + 1));
        }  

		store[index1][index2] = result;

		return result;
    }
}