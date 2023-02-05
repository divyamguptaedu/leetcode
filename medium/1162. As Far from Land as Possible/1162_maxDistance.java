class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};    
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int max = bfs(grid, queue, visited);
        if (max < 0) {
            return -1;
        } else {
            return max - 1;
        }
    }

    private int bfs(int[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int n = grid.length;
        int max = -1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];
                if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                grid[x][y] = 1 + grid[current[0]][current[1]];
                max = Math.max(max, grid[x][y]);
                queue.offer(new int[]{x, y});
            }
        }
        return max;

    }
}