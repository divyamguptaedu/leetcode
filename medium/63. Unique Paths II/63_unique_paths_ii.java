//I tackled this problem by utilizing dynamic programming to compute the number of 
//unique paths while considering obstacles. Initially, I handled the special case where 
//the starting cell is an obstacle. Then, I iteratively filled the first column and first 
//row based on whether there are obstacles or not, determining the number of ways to reach 
//each cell. Finally, starting from cell (1, 1), I calculated the number of paths by s
//umming the number of paths from the cell above and the cell to the left. 
//I updated obstacleGrid accordingly, ensuring that obstacles block paths. The result is stored in the bottom-right cell, indicating the total unique paths available.

//Time: O(mn)
//Space: O(1)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < r; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < c; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] +
                    obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[r - 1][c - 1];
    }
}