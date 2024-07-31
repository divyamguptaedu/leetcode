//Since its a shortest path problem, we can solve it using DFS. So, first we can define the directions array with all the 8 possible directions.
//Then, we can first check for the edge case when the start and end are not set to 0, in that case we return -1.
//For the BFS, we initialize the queue, set the starting point to 1, and add the starting point to the queue.
//In this BFS, we check if the current cell is the last cell, if yes, return distance.
//If not, then we get all the neighbors of this cell which have a 0 and add them to the queue and increase their distance.

//Time: O(n) where n is the total number of cells in the grid.
//Space: O(n)

class Solution {
    private static final int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                queue.add(new int[]{neighbourRow, neighbourCol});
                grid[neighbourRow][neighbourCol] = distance + 1;
            }
        }

        return -1;
    }
    
    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 0) {
                continue;    
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours; 
    }
    
}

//implemented again
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int currRow = 0;
        int currCol = 0;
        if (grid[currRow][currCol] == 1) {
            return -1;
        }
        if (rows == 1 && cols == 1) {
            return 1;
        }
        int[][] dirs = new int[][] {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
        grid[currRow][currCol] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {currRow, currCol, 1});
        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            currRow = currState[0];
            currCol = currState[1];
            int currDis = currState[2];
            for (int[] dir : dirs) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 0) {
                    if (newRow == rows - 1 && newCol == cols - 1) {
                        return currDis + 1;
                    }
                    grid[newRow][newCol] = 1;
                    queue.add(new int[] {newRow, newCol, currDis + 1});
                }
            }
        }
        return -1;
    }
}