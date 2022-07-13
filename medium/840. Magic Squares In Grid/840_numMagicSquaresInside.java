"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Magic Squares In Grid.
Memory Usage: 42.8 MB, less than 16.55% of Java online submissions for Magic Squares In Grid.
"

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid.length - 3; j++) {
                if (helper(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }
    private boolean helper(int[][] grid, int i, int j) {
        if (grid[i][j] % 2!=0 || grid[i][j + 2] % 2 != 0 || grid[i + 2][j] % 2 != 0 || grid[i + 2][j + 2] % 2 != 0) {
            return false;
        }
        if (grid[i][j + 1] % 2 == 0 || grid[i + 1][j] % 2 == 0 || grid[i + 1][j + 2] % 2 == 0 || grid[i + 2][j + 1] % 2 == 0) {
            return false;
        }
        if ((grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) ||
            (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != 15) ||
            (grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != 15) ||
            (grid[i][j + 2] + grid[i + 1][j + 2]+ grid[i + 2][j + 2] != 15)) {
            return false;
        }
        if (grid[i + 1][j + 1] != 5) {
            return false;
        }
        return true;
    }
}