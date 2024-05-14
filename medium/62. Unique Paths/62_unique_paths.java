//I initialized a 2D array to store the number of paths. 
//Then, I filled the array with 1s as the robot can only move down or right from any position. 
//Using dynamic programming, I iterated through the grid, updating each cell with the sum of the paths from the top and left cells. 
//Finally, I returned the value in the bottom-right corner, representing the total unique paths.

//Time: O(mn)
//Space: O(mn)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for (int col = 1; col < m; ++col) {
            for (int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }
}