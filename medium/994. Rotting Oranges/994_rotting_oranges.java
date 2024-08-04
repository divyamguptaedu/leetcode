class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) { // if a rotten orange, add to queue
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) { // if a fresh orange, increment fresh orange count
                    freshOranges++;
                }
            }
        }

        queue.add(new Pair(-1, -1)); // to mark one round

        int minutes = -1;
        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            int row = curr.getKey();
            int col = curr.getValue();
            if (row == -1) { // marking a new round
                minutes++;
                if (!queue.isEmpty()) {
                    queue.add(new Pair(-1, -1));
                }
            } else { // explore all adj cells which have fresh orange
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // convert to rotten
                        freshOranges--; // decrement fresh count
                        queue.add(new Pair(newRow, newCol)); // add to queue for next round
                    }
                }
            }
        }

        if (freshOranges == 0) {
            return minutes;
        } else {
            return -1;
        }
    }
}