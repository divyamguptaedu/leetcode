//I approached the Game of Life problem by iterating through each cell in the
//board and applying the rules simultaneously to determine the next state of 
//each cell based on its neighbors. Using a neighbors array, 
//I checked all eight possible neighbors for each cell, counting live neighbors. 
//Depending on the current state of the cell and the count of live neighbors, 
//I updated the cell's state accordingly: marking live cells to die (-1) or 
//marking dead cells to become alive (2). After computing the next state 
//for all cells, I finalized the board by converting temporary states (-1 and 2) 
//back to 0 and 1, respectively.

//Time: MN
//Space: constant
class Solution {
    public void gameOfLife(int[][] board) {

        // Neighbors array to find 8 neighboring cells for a given cell
        int[] neighbors = { 0, 1, -1 };

        int rows = board.length;
        int cols = board[0].length;

        // Iterate through board cell by cell.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // For each cell count the number of live neighbors.
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // Check the validity of the neighboring cell.
                            // and whether it was originally a live cell.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // Rule 1 or Rule 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 signifies the cell is now dead but originally was live.
                    board[row][col] = -1;
                }
                // Rule 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 signifies the cell is now live but was originally dead.
                    board[row][col] = 2;
                }
            }
        }

        // Get the final representation for the newly updated board.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}

//another solution
class Solution {
    int[][] dirs = new int[][] {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    int rows;
    int cols;
    int[][] board;
    public void gameOfLife(int[][] board) {
        this.board = board;
        List<int[]> changesToProcess = new ArrayList<>();
        this.rows = board.length;
        this.cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = numLiveNeighbors(i, j);
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    changesToProcess.add(new int[] {i, j, 1});
                }
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2) {
                        changesToProcess.add(new int[] {i, j, 0});
                    } 
                    if (liveNeighbors > 3) {
                        changesToProcess.add(new int[] {i, j, 0});
                    }
                }
            }
        }
        
        for (int[] change : changesToProcess) {
            board[change[0]][change[1]] = change[2];
        }
    }

    private int numLiveNeighbors(int x, int y) {
        int count = 0;
        for (int[] dir : dirs) {
            int i = x + dir[0];
            int j = y + dir[1];
            if (i >= 0 && i < rows && j >= 0 && j < cols && board[i][j] == 1) {
                count++;
            }
        }
        return count;
    }
}