//For this question, we will do a dfs to check for the longest increasing path, but will also use a cache or memory to avoid doing repeated work. 
//So, first we initialize a directions 2d array, the dimensions of the grid, and the cache. 
//Then we iterate over the grid, do dfs, find the length, save the max. 
//While doing the dfs, we also save the length in the cache to avoid repeated work in the future. 
//So, this will help us to get to our answer in O(mn)

//Time: O(mn)
//Space: O(mn)
public class Solution {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j, cache));
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
        }
        return ++cache[i][j];
    }
}