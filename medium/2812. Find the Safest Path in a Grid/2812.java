public class Solution {
    private static final int[][] DIRECTIONS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int calculateMaximumSafety(List<List<Integer>> grid) {
        int size = grid.size();
        int[][] distances = new int[size][size];
        boolean[][] visited = new boolean[size][size];
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new Pair<>(i, j));
                    visited[i][j] = true;
                }
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        int level = 0;
        int maxLevel = 0;

        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();
            while (nodesAtCurrentLevel > 0) {
                Pair<Integer, Integer> current = queue.poll();
                int row = current.getKey();
                int col = current.getValue();
                
                distances[row][col] = Math.min(level, distances[row][col]);
                maxLevel = Math.max(maxLevel, distances[row][col]);

                for (int[] dir : DIRECTIONS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (isValidPosition(newRow, newCol, size) && !visited[newRow][newCol]) {
                        queue.offer(new Pair<>(newRow, newCol));
                        visited[newRow][newCol] = true;
                    }
                }
                nodesAtCurrentLevel--;
            }
            level++;
        }

        if (grid.get(0).get(0) == 1 || grid.get(size - 1).get(size - 1) == 1) {
            return 0;
        }
        
        int result = -1;
        int low = 0, high = maxLevel;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValidSafetyLevel(distances, mid)) {
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private boolean isValidSafetyLevel(int[][] distances, int target) {
        int size = distances.length;
        boolean[][] visited = new boolean[size][size];
        return dfs(0, 0, distances, target, size, visited);
    }

    private boolean dfs(int row, int col, int[][] distances, int target, int size, boolean[][] visited) {
        if (row == size - 1 && col == size - 1) {
            return distances[size - 1][size - 1] >= target;
        }
        if (!isValidPosition(row, col, size) || visited[row][col]) {
            return false;
        }
        if (distances[row][col] < target) {
            return false;
        }
        
        visited[row][col] = true;
        boolean result = false;

        for (int[] dir : DIRECTIONS) {
            result = result || dfs(row + dir[0], col + dir[1], distances, target, size, visited);
        }
        return result;
    }

    private boolean isValidPosition(int row, int col, int size) {
        return row >= 0 && col >= 0 && row < size && col < size;
    }
}
