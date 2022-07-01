"
Performance:
Runtime: 3 ms, faster than 83.21% of Java online submissions for Max Area of Island.
Memory Usage: 47.7 MB, less than 33.45% of Java online submissions for Max Area of Island.
"

class Solution {
    int islands = 0;
    int maximum = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islands = 0;
                    helper(i, j, grid);
                    if (islands>maximum) {
                        maximum = islands;
                    }
                }
            }
        }
        return maximum;
    }
    
    public void helper (int row, int col, int[][] grid) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1) {
            grid[row][col] = 2;
            helper(row - 1, col, grid);
            helper(row, col - 1, grid);
            helper(row + 1, col, grid);
            helper(row, col + 1, grid);
            islands++;
        }
    }

}