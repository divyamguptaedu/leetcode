"
Performance:
Runtime: 1 ms, faster than 85.74% of Java online submissions for Max Increase to Keep City Skyline.
Memory Usage: 44.2 MB, less than 56.16% of Java online submissions for Max Increase to Keep City Skyline.
"

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int size = grid.length;
        int[] row = new int[size];
        int[] col = new int[size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                row[r] = Math.max(row[r], grid[r][c]);
                col[c] = Math.max(col[c], grid[r][c]);
            }
        }
        int result = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                result += Math.min(row[r], col[c]) - grid[r][c];
            }
        }
        return result;
    }
}