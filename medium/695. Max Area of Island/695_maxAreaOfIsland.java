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

//another solution

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int area = calculate(grid, row, col, 0);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }

        return max;
    }

    public int calculate(int[][] grid, int row, int col, int area) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return  calculate(grid, row + 1, col, area) +
                calculate(grid, row - 1, col, area) + 
                calculate(grid, row, col + 1, area) +
                calculate(grid, row, col - 1, area) + 1;
    }
}