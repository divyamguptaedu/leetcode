//I used a two-step approach. First, I mapped the hidden grid using a recursive backtracking
//method, marking each cell as unknown, free, obstacle, or target. 
//Starting from the initial position, I recursively explored all four directions, 
//updating the grid and backtracking to ensure I returned to the original cell. 
//After mapping, I used a Breadth-First Search (BFS) to find the shortest path from the 
//start to the target by traversing the discovered grid, tracking distances and expanding
//the search until reaching the target cell or confirming no valid path exists.

//Time:O (nm) due to BFS traversal and grid exploration.
//Space: O(nm) for storing the grid
/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 * boolean canMove(char direction);
 * void move(char direction);
 * boolean isTarget();
 * }
 */

class Solution {
    // Directions arrays to handle movements
    private static char[] directions = { 'U', 'D', 'L', 'R' };
    private static char[] opposite = { 'D', 'U', 'R', 'L' };
    private static int[] xDiff = { 0, 0, 1, -1 };
    private static int[] yDiff = { -1, 1, 0, 0 };

    public int findShortestPath(GridMaster master) {
        // Initialize grid to store the state of each cell (1005x1005 to allow some buffer space)
        byte[][] grid = new byte[1005][1005]; // 0 - unknown, 1 - free, 2 - obstacle, 3 - target
        // Backtrack to generate the map starting from the middle of the grid
        backtrack(500, 500, grid, master);
        // BFS to find the shortest path to the target
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { 500, 500, 0 });
        grid[500][500] = 1;
        while (queue.size() > 0) {
            int[] data = queue.pollFirst();
            int x = data[0];
            int y = data[1];
            // Check all four directions
            for (int i = 0; i < 4; i++) {
                // If target cell is found, return the distance
                if (grid[x + xDiff[i]][y + yDiff[i]] == 3)
                    return data[2] + 1;
                // If a free cell is found, add it to the queue for further exploration
                if (grid[x + xDiff[i]][y + yDiff[i]] == 2) {
                    grid[x + xDiff[i]][y + yDiff[i]] = 1;
                    queue.addLast(new int[] { x + xDiff[i], y + yDiff[i], data[2] + 1 });
                }
            }
        }
        // If no path to the target is found, return -1
        return -1;
    }

    public void backtrack(int x, int y, byte[][] grid, GridMaster master) {
        // If cell is already visited, return
        if (grid[x][y] != 0)
            return;
        // Mark the current cell based on whether it's the target
        if (master.isTarget()) {
            grid[x][y] = 3;
        } else {
            grid[x][y] = 2;
        }

        // Explore all four directions
        for (int i = 0; i < directions.length; i++) {
            if (grid[x + xDiff[i]][y + yDiff[i]] != 0)
                continue;
            // If the move is possible, make the move, explore, and backtrack
            if (master.canMove(directions[i])) {
                master.move(directions[i]);
                backtrack(x + xDiff[i], y + yDiff[i], grid, master);
                master.move(opposite[i]);
            } else {
                // If the move is not possible, mark it as an obstacle
                grid[x + xDiff[i]][y + yDiff[i]] = 1;
            }
        }
    }
}