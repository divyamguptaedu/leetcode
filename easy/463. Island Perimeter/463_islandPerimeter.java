class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {  
                    return dfs(grid, i, j, visited);
                }
            }
        }
        return 0;
    }
    
    public int dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return 1;
        }
        if (grid[x][y] == 0) {
            return 1;
        } else if (grid[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;
            int top = dfs(grid, x, y + 1, visited);
            int down = dfs(grid, x, y - 1, visited);
            int right = dfs(grid, x + 1, y, visited);
            int left = dfs(grid, x - 1, y, visited);
            return top + down + right + left;        
        }
        return 0;
    }
}