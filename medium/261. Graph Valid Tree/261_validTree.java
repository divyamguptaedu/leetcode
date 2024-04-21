class Solution {
    public boolean validTree(int n, int[][] edges) {
        //create the adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
            adjList.get(edge[0]).add(edge[1]);
        }
                
        HashSet<Integer> visited = new HashSet<>();
        dfs(visited, 0, adjList);
        
        return visited.size() == n && edges.length == n - 1; //to check for connected tree and loops
    }
    
     public void dfs(HashSet<Integer> visited, int currNode, List<List<Integer>> adjList) {
        visited.add(currNode);
        for (Integer node : adjList.get(currNode)) {
            if (!visited.contains(node)) {
                dfs(visited, node, adjList);
            }
        }
    }
}