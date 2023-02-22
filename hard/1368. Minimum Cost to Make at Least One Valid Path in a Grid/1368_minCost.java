class Solution {

    int[] dirX = {0,0,1,-1};
    int[] dirY = {1,-1,0,0};
    int m;
    int n;

    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2]-b[2]));
        m = grid.length;
        n = grid[0].length;
        int[][] dist = new int [m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.add(new int[] {0,0,0});
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int x = arr[0];
            int y = arr[1];
            int currDist = arr[2];
            for (int i = 0; i < 4; i++) {
                int adjX = x + dirX[i];
                int adjY = y + dirY[i];
                if (isValid(adjX,adjY)) { 
                    if (grid[x][y] != i + 1) {
                        if (1 + dist[x][y] < dist[adjX][adjY]) {
                            dist[adjX][adjY] = 1 + dist[x][y];
                            pq.add(new int[] {adjX,adjY,dist[adjX][adjY]});
                        }
                    } else {
                        if (dist[x][y] < dist[adjX][adjY]) {
                            dist[adjX][adjY] = dist[x][y];
                            pq.add(new int[] {adjX,adjY,dist[adjX][adjY]});
                        }
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
    public boolean isValid(int x,int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        return true;
    }
}