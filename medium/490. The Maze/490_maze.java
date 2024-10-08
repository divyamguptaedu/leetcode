//Get the dimensions and create a visited 2d boolean array. 
//Run dfs. In the dfs, if a cell is already visited, then return false, if it's the destination, return true. 
//If none, then mark it as visited, and move the pointer in the possible four directions while the possible move is still valid, 
//then recurse using dfs again. 
//DFS takes O(mn) and discovering the neighboring nodes in each direction with a while loop takes O(m) + O(n). 

//Time: O(mn(m+n))
//Space: O(mn)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visit = new boolean[m][n];
        return dfs(m, n, maze, start, destination, visit);
    }
    public boolean dfs(int m, int n, int[][] maze, int[] curr, int[] destination, boolean[][] visit) {
        if (visit[curr[0]][curr[1]]) {
            return false;
        }
        if (curr[0] == destination[0] && curr[1] == destination[1]) {
            return true;
        }

        visit[curr[0]][curr[1]] = true;
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};

        for (int i = 0; i < 4; i++) {
            int r = curr[0];
            int c = curr[1];
            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) { //move the r and c while it can
                r += dirX[i];
                c += dirY[i];
            }
            //recurse
            if (dfs(m, n, maze, new int[]{r - dirX[i], c - dirY[i]}, destination, visit)) {
                return true;
            }
        }
        return false;
    }
}

//implemented again
class Solution {
    int rows;
    int cols;
    boolean[][] visited;
    int[][] maze;
    int[] destination;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.rows = maze.length;
        this.cols = maze[0].length;
        this.visited = new boolean[rows][cols];
        this.destination = destination;
        this.dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        this.maze = maze;
        return find(start[0], start[1]);
    }

    private boolean find(int i, int j) {
        if (visited[i][j]) return false;
        if (i == destination[0] && j == destination[1]) return true;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int newRow = i;
            int newCol = j;
            while (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && maze[newRow][newCol] == 0) {
                newRow += dir[0];
                newCol += dir[1];
            }
            if (find(newRow - dir[0], newCol - dir[1])) {
                return true;
            }
        }
        return false;
    }
}