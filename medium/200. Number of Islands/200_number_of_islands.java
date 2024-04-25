//First get the numRows and numCols, then set a double for-loop, check if that current cell is a 1 or 0, if 1, then save to visited, and check its neighbors. If not, move to next.
//Time: O(mn)
//Space: O(min(m,n))
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == '1') {
                    num_islands++;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * cols + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / cols;
                        int col = id % cols;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * cols + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < rows && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * cols + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * cols + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < cols && grid[row][col+1] == '1') {
                            neighbors.add(row * cols + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}