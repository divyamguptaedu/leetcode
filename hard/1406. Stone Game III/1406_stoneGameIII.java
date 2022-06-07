"""
Performance:
Runtime: 27 ms, faster than 59.11% of Java online submissions for Stone Game III.
Memory Usage: 117.2 MB, less than 69.33% of Java online submissions for Stone Game III.
"""

class Solution {
    public String stoneGameIII(int[] piles) {
        int score = getAliceScore(piles);       
        if (score > 0) { 
            return "Alice";
        } else if (score < 0) { 
            return "Bob";  
        }
        return "Tie";
    }
    
    private int getAliceScore(int[] piles) {
        int size = piles.length;
        int[] result = new int[size + 1];
        for (int i = size - 1; i >= 0; i = i - 1) {          
             result[i] = piles[i] - result[i + 1];           
             if (i < size - 1) {
                 result[i] = Math.max(piles[i] + piles[i + 1] - result[i + 2],  result[i]);
             }          
             if (i < size - 2) {
                 result[i] = Math.max(piles[i] + piles[i + 1] + piles[i + 2] - result[i + 3],  result[i]);
             }
        }
        return result[0];
    }
}