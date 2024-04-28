//To find the shortest distance from all buildings, we can either start from all the empty spaces and kick off a 4 directional BFS to all the houses.
//Or we can start from the houses and kick off a 4 directional BFS to the empty spaces. 
//Depending on which is more, houses or empty spaces, we can chose the approach. I will go with houses to empty spaces. 
//As we do the BFS, we will need to maintain a visited set, but to optimize the space complexity, we can just edit the empty space value instead. 
//For example, after first iter, we can change empty space values to -1, then after second iter, change it to -2 and so on. 
//We will maintain a distance matrix to account for the total distance that each empty space has to all houses.
//We will kick off a BFS for all the houses one by one, initialize a queue, go level by level and update the distance matrix and update the cell value to mark as visited.
//In the end we return the minimum distance value.

//Time complexity: O(n^2 . m^2) where n and m are rows and cols. Go from each house to each empty space.
//Space complexity: O(nm) for the distance matrix maintained.
class Solution {
    public int shortestDistance(int[][] grid) {
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] distanceMatrix = new int[rows][cols];

        int emptyLandValue = 0;
        int minDist = Integer.MAX_VALUE;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) { //for all the houses
                    minDist = Integer.MAX_VALUE;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{ row, col });
                    int steps = 0;
                    while (!q.isEmpty()) {
                        steps++;
                        for (int level = q.size(); level > 0; level--) { //level by level, each level is an increase of distance of 1.
                            int[] curr = q.poll();
                            for (int[] dir : dirs) {
                                int nextRow = curr[0] + dir[0];
                                int nextCol = curr[1] + dir[1];

                                if (nextRow >= 0 && nextRow < rows &&
                                    nextCol >= 0 && nextCol < cols &&
                                    grid[nextRow][nextCol] == emptyLandValue) {
                                    grid[nextRow][nextCol]--;
                                    distanceMatrix[nextRow][nextCol] += steps;

                                    q.offer(new int[]{ nextRow, nextCol });
                                    minDist = Math.min(minDist, distanceMatrix[nextRow][nextCol]);
                                }
                            }
                        }
                    }

                    // Decrement empty land value to be searched in next iteration.
                    emptyLandValue--;
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}