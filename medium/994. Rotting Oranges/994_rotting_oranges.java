class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int countFresh = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        if (countFresh == 0) {
            return 0;
        }
        int time = 0;
        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};
        int count = 0 - queue.size();
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int[] popped = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = popped[0] + directionX[j];
                    int y = popped[1] + directionY[j];
                    if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[] {x, y});
                }
            }
            if (queue.size() != 0) {
                time++;
            }
        }
        if (countFresh == count) {
            return time;
        } else {
            return -1;
        }
    }
}





