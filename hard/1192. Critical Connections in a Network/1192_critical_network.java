//I approached the problem of finding critical connections in a network using Tarjan's algorithm, 
//which utilizes Depth-First Search (DFS) to identify bridges (critical connections). 
//Initially, I constructed an adjacency list (adj) to represent the graph from the given connections. 
//During DFS traversal, I tracked several properties for each node: time (discovery time), 
//low (lowest discovery time reachable), and vis (visited status). 
//If a connection (node, it) formed a bridge (where time[node] < low[it]), 
//I added it to the bridges list. This approach effectively identifies edges whose removal would 
//disconnect parts of the network. Finally, I returned all stored critical connections in bridges.
//Time: v+e
//Space: v+e
class Solution {
    int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }

        for (List<Integer> ls : connections) {
            int u = ls.get(0);
            int v = ls.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        int[] time = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList();
        dfs(0, -1, vis, adj, time, low, bridges);
        return bridges;
    }

    void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj, int[] time, int[] low,
            List<List<Integer>> bridges) {
        vis[node] = 1;
        time[node] = timer;
        low[node] = timer;
        timer++;
        for (int it : adj.get(node)) {
            if (it == parent)
                continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, adj, time, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                if (time[node] < low[it]) {
                    bridges.add(Arrays.asList(node, it));
                }
            } else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}