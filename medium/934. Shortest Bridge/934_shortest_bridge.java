//I am going to use DFS to locate the first island, then use BFS to find the shortest
//way to the second island. We can solve this problem using BFS for both the tasks, but 
//DFS+BFS is more intuitive and both solutions will result into the same time complexity.

//I located the first island using a DFS to mark all its cells and 
//added these cells to a queue. Then, I used a BFS to expand outwards from the marked
//island cells, looking for the second island. 
//At each BFS step, I flipped the encountered water cells (0s) to visited cells (-1s).
//This process continued until I found a cell belonging to the second island, 
//ensuring that the number of flips was minimized.

//Time: O(n^2)
//Space: O(n^2)
class Solution {
    private List<int[]> bfsQueue;

    // Find the shortest bridge to connect two islands
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int firstIslandX = -1, firstIslandY = -1;

        // Find the first land cell, which belongs to the first island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    firstIslandX = i;
                    firstIslandY = j;
                    break;
                }
            }
            if (firstIslandX != -1) {
                break;
            }
        }

        // Initialize BFS queue and mark the first island
        bfsQueue = new ArrayList<>();
        markIslandDFS(grid, firstIslandX, firstIslandY, n);

        int distance = 0;
        while (!bfsQueue.isEmpty()) {
            List<int[]> newQueue = new ArrayList<>();
            for (int[] cell : bfsQueue) {
                int x = cell[0], y = cell[1];
                for (int[] direction : new int[][] { { x + 1, y }, { x - 1, y }, { x, y + 1 }, { x, y - 1 } }) {
                    int newX = direction[0], newY = direction[1];
                    if (0 <= newX && newX < n && 0 <= newY && newY < n) {
                        if (grid[newX][newY] == 1) {
                            return distance;
                        } else if (grid[newX][newY] == 0) {
                            newQueue.add(new int[] { newX, newY });
                            grid[newX][newY] = -1; // Mark as visited
                        }
                    }
                }
            }
            bfsQueue = newQueue;
            distance++;
        }
        return distance;
    }

    // Recursively mark the first island and add its cells to the BFS queue
    private void markIslandDFS(int[][] grid, int x, int y, int n) {
        grid[x][y] = 2; // Mark the cell as visited
        bfsQueue.add(new int[] { x, y });
        for (int[] direction : new int[][] { { x + 1, y }, { x - 1, y }, { x, y + 1 }, { x, y - 1 } }) {
            int newX = direction[0], newY = direction[1];
            if (0 <= newX && newX < n && 0 <= newY && newY < n && grid[newX][newY] == 1) {
                markIslandDFS(grid, newX, newY, n);
            }
        }
    }

}