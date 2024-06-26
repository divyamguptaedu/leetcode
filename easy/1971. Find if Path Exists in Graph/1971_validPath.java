//Make adj list, visited set, and a queue to store the nodes to be visited. 
//Added a starting node 0 to the queue and marked as visited. 
//Ran BFS, returned true of current node is the destination. 
//Added all unvisited nodes to the queue, marked them as visited.
//Time: O(n+m)
//Space: O(n+m)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>(); //adj list
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        boolean[] visited = new boolean[n];
        visited[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (currNode == destination) {
                return true; 
            }
            for (int nextNode : graph.get(currNode)) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        
        return false;
    }
}