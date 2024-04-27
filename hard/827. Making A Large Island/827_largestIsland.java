//We can solve it the naive way which means doing DFS everytime we see a 0 and checking how large of an island will be formed. 
//However, it will involve a lot of repeated work. 
//So, we will instead save that work using some ids to represent a precalculated island. 
//So, we first do a interation over the grid and check if the current cell is a 1, 
//if it is a 1, then we do dfs on it and find its area, change these island cells to an island id and save the area. 
//Then we quickly find the max area till now. Then we iterate over the grid again, and this time, check if there is a 0, 
//when we find a 0, we check its neighbors. If any of the neighbor has an island id, we add it to the scene set. 
//In the end, we just add all the area of ids in the seen set and add 1 to it to account for the changed cell, and return the max area.

//Time: O(n^2)
//Space: O(n^2)
class Solution {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    int[][] grid;
    int N;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        N = grid.length;

        int index = 2;
        int[] area = new int[N*N + 2];
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] == 1)
                    area[index] = dfs(r, c, index++);

        int ans = 0;
        for (int x : area) {
            ans = Math.max(ans, x);
        }
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] == 0) {
                    Set<Integer> foundIsland = new HashSet();
                    for (Integer move: neighbors(r, c))
                        if (grid[move / N][move % N] > 1)
                            foundIsland.add(grid[move / N][move % N]);

                    int currentArea = 1;
                    for (int i: foundIsland) currentArea += area[i];
                    ans = Math.max(ans, currentArea);
                }

        return ans;
    }

    public int dfs(int r, int c, int index) {
        int ans = 1;
        grid[r][c] = index;
        for (Integer move: neighbors(r, c)) {
            if (grid[move / N][move % N] == 1) {
                grid[move / N][move % N] = index;
                ans += dfs(move / N, move % N, index);
            }
        }

        return ans;
    }

    public List<Integer> neighbors(int r, int c) {
        List<Integer> ans = new ArrayList();
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < N && 0 <= nc && nc < N)
                ans.add(nr * N + nc);
        }

        return ans;
    }
}