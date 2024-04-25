//The task involves finding the area of each connected shape in a grid and then determining the maximum area among them. 
//To achieve this, we explore each land square and recursively visit all squares connected to it in four directions. 
//We keep track of visited squares to avoid counting them more than once and ensure each shape is counted only once.
//Time: O(rc)
//Space: O(rc)
class Solution {
    int[][] grid;
    boolean[][] seen;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }
    public int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || seen[r][c] || grid[r][c] == 0) {
            return 0;
        }
        seen[r][c] = true;
        return (1 + area(r+1, c) + area(r-1, c) + area(r, c-1) + area(r, c+1));
    }
}