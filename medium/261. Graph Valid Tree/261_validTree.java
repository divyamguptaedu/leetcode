//First checked if the #edges is not equal to n-1, then returned false, this is to check if the tree is connected.
//Then created the adj list, did dfs, and after dfs checked if the size of the visited is equal to the number of nodes.
//In DFS, just added to the visited set.
//Time: O(N) where N is the number of nodes.
//Space: O(N)
class Solution {
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private Set<Integer> seen = new HashSet<>();  

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        // Make the adjacency list.
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        // Carry out depth first search.
        dfs(0);
        // Inspect result and return the verdict.
        return seen.size() == n;   
    }
    
    public void dfs(int node) {
        if (seen.contains(node)) return;
        seen.add(node);
        for (int neighbour : adjacencyList.get(node)) {
            dfs(neighbour);
        }
    }
}