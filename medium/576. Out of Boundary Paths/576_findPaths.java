"""
Performance:
Runtime: 7 ms, faster than 76.38% of Java online submissions for Out of Boundary Paths.
Memory Usage: 43.5 MB, less than 23.62% of Java online submissions for Out of Boundary Paths.
"""

class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] result = new Integer[m][n][maxMove + 1];
        return helper (m, n, maxMove, startRow, startColumn, result);
    }
    private int helper (int m, int n, int move, int i, int j, Integer[][][] result) {
        int divider = 1000000007;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }
        if (move <= 0) {
            return 0;
        }
        if (result[i][j][move] != null) {
            return result[i][j][move];
        }
        int answer = 0;
        answer = answer % divider + helper(m, n, move - 1, i - 1, j, result) % divider;
        answer = answer % divider + helper(m, n, move - 1, i + 1, j, result) % divider;
        answer = answer % divider + helper(m, n, move - 1, i, j - 1, result) % divider;
        answer = answer % divider + helper(m, n, move - 1, i, j + 1, result) % divider;
        result[i][j][move] = answer % divider;
        return result[i][j][move];
    }
}