//I used a breadth-first search (BFS) approach to update the distances of empty rooms
//to the nearest gate. First, I added all gates to a queue.
//Then, I processed each gate by exploring its neighboring cells in four directions.
//If a neighboring cell was an empty room, 
//I updated its distance to be one more than the current cell’s distance and added
//it to the queue. This ensured that all empty rooms were filled with the shortest
//distance to the nearest gate by expanding layer by layer from each gate.

//Time: mn
//Space: mn
class Solution {
    // Constants representing empty rooms and gates
    int EMPTY = Integer.MAX_VALUE;
    int GATE = 0;
    // Directions for moving up, down, left, and right
    List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1, 0 },
            new int[] { -1, 0 },
            new int[] { 0, 1 },
            new int[] { 0, -1 });

    public void wallsAndGates(int[][] rooms) {
        int numRows = rooms.length;
        if (numRows == 0) {
            return; // If the grid is empty, return immediately
        }
        int numCols = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Enqueue all gates
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (rooms[row][col] == GATE) {
                    queue.add(new int[] { row, col });
                }
            }
        }
        
        // BFS to update distances from gates
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            
            // Explore neighbors
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                
                // Continue if out of bounds or not an empty room
                if (newRow < 0 || newCol < 0 || newRow >= numRows || newCol >= numCols || rooms[newRow][newCol] != EMPTY) {
                    continue;
                }
                
                // Update the distance and enqueue the new point
                rooms[newRow][newCol] = rooms[row][col] + 1;
                queue.add(new int[] { newRow, newCol });
            }
        }
    }
}

//another solution
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        int[][] dirs = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || r >= rows || c < 0 || c >= cols || rooms[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[] {r, c});
            }
        }

    }
}