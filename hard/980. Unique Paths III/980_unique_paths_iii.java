"
Performance:
Runtime: 1 ms, faster than 87.24% of Java online submissions for Unique Paths III.
Memory Usage: 41.3 MB, less than 64.34% of Java online submissions for Unique Paths III.
"

class Solution {
    
    int count = 1;
    int result = 0;
    int root;
    int cell;
    
    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0)
                    count++;
                if (grid[i][j] == 1) {
                    root = i;
                    cell = j;
                }
            }
        }
        helper(grid, root, cell);
        return result;
    }
    
    public void helper(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] < 0)
            return;
        if (grid[x][y] == 2) {
            if (count == 0)
                result++;
            return;
        }
        grid[x][y] = -2;
        count--;
        helper(grid, x + 1, y);
        helper(grid, x, y + 1);
        helper(grid, x - 1, y);
        helper(grid, x, y - 1);
        count++;
        grid[x][y] = 0;
    }
}