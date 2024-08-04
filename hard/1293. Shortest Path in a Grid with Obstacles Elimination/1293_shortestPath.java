//I tackled the problem using a breadth-first search.
//I initialized a queue to explore cells and 
//a 2D array to track the number of obstacles eliminated at each cell. 
//Starting from the upper-left corner, 
//I iteratively explored neighboring cells, updating the obstacles eliminated and 
//enqueueing cells with fewer eliminated obstacles.
//The process continues until reaching the lower-right corner or exhausting all
//possible paths. This approach ensures finding the shortest path while considering
//obstacle eliminations. If no path satisfies the constraints, I return -1.

// Time: O(mn * min(m + n, k)) where m and n are the dimensions of the grid,
//and k is the maximum number of obstacles to eliminate. 
//We traverse the entire grid, and for each cell, we explore up to min(m + n, k) steps.
// Space: O(mn * min(m + n, k))
class Solution {
    public int shortestPath(int[][] grid, int k) {
        // Check if the grid is empty
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1; // Return -1 for empty grid
        }

        int m = grid.length; // Number of rows in the grid
        int n = grid[0].length; // Number of columns in the grid
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // Directions: right, left, down, up

        Queue<int[]> queue = new LinkedList<>(); // Queue to store cell states during BFS
        int[][] obstaclesEliminated = new int[m][n]; // 2D array to track the number of obstacles eliminated

        // Initialize the obstaclesEliminated array with a large value (k + 1)
        for (int[] row : obstaclesEliminated) {
            Arrays.fill(row, k + 1);
        }

        queue.offer(new int[] { 0, 0 }); // Start from the upper-left corner
        obstaclesEliminated[0][0] = 0; // No obstacles eliminated at the start
        int steps = 0; // Initialize step count

        // Perform BFS until the queue is empty
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process nodes at the current level
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll(); // Dequeue the current cell
                int row = current[0], col = current[1]; // Extract row and column indices

                // Check if reached the destination (lower-right corner)
                if (row == m - 1 && col == n - 1) {
                    return steps; // Return the number of steps taken to reach the destination
                }

                // Explore the four possible directions from the current cell
                for (int[] dir : directions) {
                    int newRow = row + dir[0]; // Calculate the new row index
                    int newCol = col + dir[1]; // Calculate the new column index

                    // Check if the new cell is within the grid boundaries
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        int newObstaclesEliminated = obstaclesEliminated[row][col] + grid[newRow][newCol];

                        // If eliminating obstacles in the new cell results in fewer obstacles
                        // eliminated
                        // and the number of obstacles eliminated is within the limit k
                        if (newObstaclesEliminated < obstaclesEliminated[newRow][newCol] && newObstaclesEliminated <= k) {
                            obstaclesEliminated[newRow][newCol] = newObstaclesEliminated; // Update obstacles eliminated
                            queue.offer(new int[] { newRow, newCol }); // Enqueue the new cell
                        }
                    }
                }
            }
            steps++; // Increment the step count
        }
        return -1; // Return -1 if no valid path is found within the constraints
    }
}

//another solution
class State {
    int distanceFromStart;
    int row;
    int col;
    int k;

    public State(int distanceFromStart, int row, int col, int k) {
        this.distanceFromStart = distanceFromStart;
        this.row = row;
        this.col = col;
        this.k = k;
    }

    @Override
    public int hashCode() {
        return (this.row * 100) + (this.col * 10) + this.k;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof State)) return false;
        State newState = (State) other;
        return (this.row == newState.row && this.col == newState.col && this.k == newState.k);
    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        if (rows + cols - 2 <= k) return rows + cols - 2;
        Queue<State> queue = new LinkedList<>();
        HashSet<State> seen = new HashSet<>();
        State start = new State(0, 0, 0, k);
        queue.add(start);
        seen.add(start);
        while (!queue.isEmpty()) {
            State curr = queue.poll();
            if (curr.row == rows - 1 && curr.col == cols - 1) return curr.distanceFromStart;
            for (int[] dir : dirs) {
                int nextRow = curr.row + dir[0];
                int nextCol = curr.col + dir[1];
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                    int nextK = curr.k - grid[nextRow][nextCol];
                    State newState = new State(curr.distanceFromStart + 1, nextRow, nextCol, nextK);
                    if (nextK >= 0 && !seen.contains(newState)) {
                        seen.add(newState);
                        queue.add(newState);
                    }
                }
            }
        }
        return -1;
    }
}