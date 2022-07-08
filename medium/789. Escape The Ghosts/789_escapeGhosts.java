"
Performance:
Runtime: 1 ms, faster than 35.00% of Java online submissions for Escape The Ghosts.
Memory Usage: 42.8 MB, less than 43.33% of Java online submissions for Escape The Ghosts.
"

class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) { 
        int userDistance = Math.abs(target[0] - 0) + Math.abs(target[1] - 0);
        int ghostDistance = Integer.MAX_VALUE; 
        for (int[] ghost : ghosts) { 
            int current = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]); 
            ghostDistance = Math.min(current, ghostDistance);
        } 
        return ghostDistance <= userDistance ? false : true; 
    } 
}