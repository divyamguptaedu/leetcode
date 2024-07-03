//I used a Depth-First Search (DFS) approach to detect cycles in a 2D grid. 
//Starting from each unvisited cell, I recursively explored its neighbors with the same value. 
//If I revisited a cell and the path length was 4 or more, I identified it as a cycle. 
//I maintained a visited array to track the cells and their visit order. 
//By checking adjacent cells while avoiding immediate backtracking, I ensured valid path exploration. 
//If a cycle was found during the DFS, I returned true; otherwise, I continued until all cells were checked.
//Time: mn
//Space: mn
class Solution {
    int count = 0;

    public boolean dfs(char[][] grid, int row, int col, int[][] visited, int prevRow, int prevCol, char currentChar) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != currentChar)
            return false;

        if (visited[row][col] - visited[prevRow][prevCol] >= 3)
            return true;

        if (visited[row][col] != 0)
            return false;

        visited[row][col] = count++;

        return dfs(grid, row + 1, col, visited, row, col, currentChar) ||
                dfs(grid, row - 1, col, visited, row, col, currentChar) ||
                dfs(grid, row, col + 1, visited, row, col, currentChar) ||
                dfs(grid, row, col - 1, visited, row, col, currentChar);
    }

    public boolean containsCycle(char[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (visited[row][col] == 0 && dfs(grid, row, col, visited, row, col, grid[row][col]))
                    return true;
            }
        }
        return false;
    }
}