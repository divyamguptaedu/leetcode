"
Performance:
Runtime: 3 ms, faster than 52.36% of Java online submissions for Rotting Oranges.
Memory Usage: 39.2 MB, less than 16.51% of Java online submissions for Rotting Oranges.
"

class Solution {
    
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
        	return -1;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                	helper(grid, i, j, 2);
                }
            }
        }
        
        int minutes = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }
        
        return minutes - 2;
    }
    
    private void helper(int[][] grid, int i, int j, int minutes) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0|| (1 < grid[i][j] && grid[i][j] < minutes)) {
        	return;
        } else {
            grid[i][j] = minutes;
            helper(grid, i - 1, j, minutes + 1);
            helper(grid, i + 1, j, minutes + 1);
            helper(grid, i, j - 1, minutes + 1);
            helper(grid, i, j + 1, minutes + 1);
        }
    }
}