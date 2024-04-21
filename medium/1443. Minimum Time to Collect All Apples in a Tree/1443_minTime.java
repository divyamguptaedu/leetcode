//Time: O(n)
//Space: O(n)
class Solution {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) { //create the adjacency list
            int firstNode = edge[0];
            int secondNode = edge[1];
            adjList.computeIfAbsent(firstNode, value -> new ArrayList<Integer>()).add(secondNode);
            adjList.computeIfAbsent(secondNode, value -> new ArrayList<Integer>()).add(firstNode);
        }
        return dfs(0, -1, hasApple, adjList);
    }
    public int dfs(int node, int parent, List<Boolean> hasApple, HashMap<Integer, List<Integer>>  adjList) {
        if (!adjList.containsKey(node)) {
            return 0;
        }

        int totalTime = 0;
        int childTime = 0;

        for (int child : adjList.get(node)) {
            if (child == parent) {
                continue;
            }
            childTime = dfs(child, node, hasApple, adjList);
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}