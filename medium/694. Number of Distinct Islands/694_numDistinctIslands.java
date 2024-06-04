//I traversed a binary matrix to identify distinct islands. 
//I used Depth-First Search (DFS) to explore each island, 
//encoding its shape as a string of directional movements. 
//This string representation allowed me to easily compare different islands. 
//If two islands produced the same string, they were considered identical. 
//By storing these strings in a set, I ensured that only unique islands were counted.

//Time: O(mn)
//Space: O(mn)
class Solution {
    private int[][] grid; // The grid representing the map
    private boolean[][] visited; // To keep track of visited cells
    private StringBuffer currentIsland; // To store the shape of the current island

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        Set<String> islands = new HashSet<>(); // To store unique island shapes

        // Iterate over each cell in the grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                currentIsland = new StringBuffer(); // Reset for each new island
                dfs(row, col, '0'); // Start DFS to explore the island
                if (currentIsland.length() == 0) {
                    continue; // Skip if no island found starting from this cell
                }
                islands.add(currentIsland.toString()); // Add the island shape to the set
            }
        }
        return islands.size(); // The number of unique islands
    }

    // Helper method to perform DFS
    private void dfs(int row, int col, char dir) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return; // Out of bounds check
        }
        if (visited[row][col] || grid[row][col] == 0) {
            return; // If already visited or water
        }
        visited[row][col] = true; // Mark the cell as visited
        currentIsland.append(dir); // Append the direction to the shape

        // Explore all four directions
        dfs(row + 1, col, 'D'); // Down
        dfs(row - 1, col, 'U'); // Up
        dfs(row, col + 1, 'R'); // Right
        dfs(row, col - 1, 'L'); // Left

        currentIsland.append('0'); // Mark the end of the path in this direction
    }
}