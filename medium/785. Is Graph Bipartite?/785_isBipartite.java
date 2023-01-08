"
Performance:
Runtime: 1 ms, faster than 88.15% of Java online submissions for Is Graph Bipartite?.
Memory Usage: 54.3 MB, less than 18.85% of Java online submissions for Is Graph Bipartite?.
"

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1) 
                if (!helper(i, graph, visited)) {
                    return false;
                }
        }
        return true;
    }
    
    private boolean helper(int node, int[][] graph, int[] visited) {
        if (visited[node] == -1) {
            visited[node] = 1;
        }
        for (int i : graph[node]) {
            if (visited[i] == -1) {
                visited[i] = 1 - visited[node];
                if (!helper(i, graph,visited)) {
                    return false;
                }
            }
            else if (visited[i] == visited[node]) {
                return false;
            }
        }
        return true;
    }
} 

// other way

class Solution {
    private boolean isSameColored(int node, int color, int[] vis, int[][] graph) {
        vis[node] = color;
        for (int it : graph[node]) {
            if (vis[it] == 0) {
                if (isSameColored(it, -color, vis, graph) == true)
                    return true;
            }
            else if (vis[it] == color)
                return true;
        }
        return false;
        
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if (isSameColored(i, 1, vis, graph) == true)
                    return false;
            }
        }
        return true;
    }
}