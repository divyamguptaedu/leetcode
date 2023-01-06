class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && markVisited(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean markVisited(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        markVisited(i+1, j, grid);
        markVisited(i, j+1, grid);
        markVisited(i-1, j, grid);
        markVisited(i, j-1, grid);
        return true;
    }
}