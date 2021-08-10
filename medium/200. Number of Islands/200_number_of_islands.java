"""
Performance:
Runtime: 1 ms, faster than 99.95% of Java online submissions for Number of Islands.
Memory Usage: 41.7 MB, less than 27.65% of Java online submissions for Number of Islands.
"""

class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count ++;
                    checkAdjacent(grid, m, n, i, j);
                }
            }
        }
        return count;
    }
    private void checkAdjacent(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'X';
        checkAdjacent(grid, m, n, i - 1, j);
        checkAdjacent(grid, m, n, i + 1, j);
        checkAdjacent(grid, m, n, i, j - 1);
        checkAdjacent(grid, m, n, i, j + 1);
    }
}