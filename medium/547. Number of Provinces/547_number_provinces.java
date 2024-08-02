//I used Depth-First Search (DFS). I treated the isConnected matrix as an adjacency matrix of a graph. 
//I initialized a visited array to keep track of visited cities. For each city, if it wasn't visited, 
//I incremented the province count and performed DFS to mark all directly and 
//indirectly connected cities as visited. This way, each DFS traversal marked one complete province.
//Time: n^2
//Space: n
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }

    private void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }
}

//another solution
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int result = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                dfs(i, isConnected, visited);
            }
        }

        return result;
    }

    private void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    }
}