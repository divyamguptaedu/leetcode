//I used Dijkstra's algorithm to find the minimum effort path from the top-left cell
//to the bottom-right cell. I initialize a priority queue to keep track of cells with
//the minimum effort. Starting from the top-left cell, I explore adjacent cells and
//update the effort required to reach them. 
//I continue this process until reaching the bottom-right cell.
//At each step, I prioritize cells with lower effort.
//Finally, I return the effort required to reach the bottom-right cell.

//Time: m*n*(log m*n)
//Space: mn
class Pair {
    int first;
    int second;
    int dis;

    Pair (int first, int second, int dis) {
        this.first = first;
        this.second = second;
        this.dis = dis;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        // Array to store the minimum effort to reach each cell
        int[][] minEffort = new int[row][col];

        // Priority queue to store cells with the minimum effort
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dis - y.dis);

        // Initialize minimum effort for all cells to infinity
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                minEffort[i][j] = Integer.MAX_VALUE;
            }
        }

        // Start from the top-left cell
        minEffort[0][0] = 0;
        pq.add(new Pair(0, 0, 0));

        // Directions to move: up, down, right, left
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        while (!pq.isEmpty()) {
            int r = pq.peek().first;
            int c = pq.peek().second;
            int dis = pq.peek().dis;

            pq.remove();

            // If reached the bottom-right cell, return the effort
            if (r == row - 1 && c == col - 1) {
                return minEffort[r][c];
            }

            // Explore adjacent cells
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                    // Calculate the effort to move to the adjacent cell
                    int newEffort = Math.max(dis, Math.abs(heights[nr][nc] - heights[r][c]));
                    
                    // Update the minimum effort if it's less than the current effort
                    if (newEffort < minEffort[nr][nc]) {
                        minEffort[nr][nc] = newEffort;
                        pq.add(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }
        // If no path found, return -1
        return -1;
    }
}