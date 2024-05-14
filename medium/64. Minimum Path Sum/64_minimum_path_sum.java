//We can use a DP approach to solve this question. We can also just store the minimum sums in the grid, without having to create an extra 3d array.
//I iterated through the grid from the bottom-right corner to the top-left corner, 
//updating each cell's value with the minimum sum path from that cell to the bottom-right corner. 

//Time: O(mn)
//Space: O(1)
public class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) { //edge
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (j == grid[0].length - 1 && i != grid.length - 1) { //edge
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (j != grid[0].length - 1 && i != grid.length - 1) { //middle elements
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }
        return grid[0][0];
    }
}