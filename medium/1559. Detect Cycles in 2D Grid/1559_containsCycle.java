//I approached the problem by using the Union-Find algorithm to detect cycles in the grid. 
//I treated each cell as a node and connected nodes with the same character. 
//For each cell, I checked its right and down neighbors. 
//If two connected nodes were already in the same set, it indicated a cycle. 
//I used path compression in the Union-Find structure to optimize the union and find operations. 
//This way, I efficiently detected cycles in the grid.
//Time: mn
//Space: mn
class Solution {
    private int[] parent;

    public boolean containsCycle(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        parent = new int[rows * cols];

        // Initialize the Union-Find parent array
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int[] directions = {0, 1, 0}; // Directions to check right and down neighbors

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < 2; k++) { // Check right and down neighbors
                    int newRow = i + directions[k];
                    int newCol = j + directions[k + 1];

                    // Check if within bounds and same character
                    if (newRow < rows && newCol < cols && grid[i][j] == grid[newRow][newCol]) {
                        if (find(newRow * cols + newCol) == find(i * cols + j)) {
                            return true; // Cycle detected
                        }
                        union(newRow * cols + newCol, i * cols + j); // Union the nodes
                    }
                }
            }
        }
        return false;
    }

    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union two sets
    private void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
