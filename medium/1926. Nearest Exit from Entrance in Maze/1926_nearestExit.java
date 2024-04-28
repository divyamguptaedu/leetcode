//Since we need to find the shortest distance we can use BFS. 
//First we define the directions array, get the starting position, set it to visited, add it to the queue along with the distance.
//Then in the while loop for the BFS, for every direction, we check if it takes us to the edge, if yes, we add to the current distance.
//If not, we mark the current as visited and add the empty neighbor cells to the queue.

//Time: O(n) where n is the total number of cells.
//Space: O(max(#rows, #col))
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = maze.length;
        int cols = maze[0].length;
        int startRow = entrance[0];
        int startCol = entrance[1];
        maze[startRow][startCol] = '+';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0});
        
        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            int currRow = currState[0];
            int currCol = currState[1];
            int currDistance = currState[2];
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols && maze[nextRow][nextCol] == '.') {
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1) { //if we are at the edge of the maze
                        return currDistance + 1;
                    }
                    maze[nextRow][nextCol] = '+'; //mark as visited
                    queue.offer(new int[]{nextRow, nextCol, currDistance + 1});
                }  
            }
        }
        return -1;
    }
}