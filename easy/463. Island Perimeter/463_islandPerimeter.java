//I approached the problem of calculating the perimeter of the island in a 2D grid by iterating through each cell. 
//For each land cell (grid[r][c] == 1), I initially added 4 to the perimeter, assuming it's surrounded on all sides. 
//Then, I checked adjacent cells to subtract potential shared edges (result -= 2 for each adjacent land cell).
//Time: mn
//Space: constant
class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    result += 4;
                    if (r > 0 && grid[r - 1][c] == 1) {
                        result -= 2;
                    }
                    if (c > 0 && grid[r][c - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}

//another solution
class Solution {
    int rows;
    int cols;
    int perimeter;
    int[][] dirs;
    int[][] grid;
    boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.perimeter = 0;
        this.dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        this.visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                } 
            }
        }
        return perimeter;
    }

    private void dfs(int row, int col) {
        if (visited[row][col]) return;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int i = row + dir[0];
            int j = col + dir[1];
            if (i >= 0 && i < rows && j >= 0 && j < cols) {
                if (grid[i][j] == 0) {
                    perimeter++;
                } else {
                    dfs(i, j);
                }
            } else {
                perimeter++;
            }
        }

    }
}