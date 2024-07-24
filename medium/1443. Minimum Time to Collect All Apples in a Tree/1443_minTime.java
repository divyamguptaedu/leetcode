//More of a graph question than a tree question. 
//But, first I created the adjacency list and then did DFS. 
//Everytime an apple is found, the time it takes from the parent to child node to fetch the apple is set at +2, 
//not +1, as I need to account for both going to the node and coming back from it. 
//After DFS, the total time is returned.

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

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            if (!adjList.containsKey(edge[0])) {
                adjList.put(edge[0], new ArrayList<>());
            }
            if (!adjList.containsKey(edge[1])) {
                adjList.put(edge[1], new ArrayList<>());
            }
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return traversal(0, -1, adjList, hasApple);
    }

    private int traversal(int node, int parent, Map<Integer, List<Integer>> adjList, List<Boolean> hasApple) {
        if (!adjList.containsKey(node)) {
            return 0;
        }
        int totalTime = 0;
        int childTime = 0;
        for (int child : adjList.get(node)) {
            if (child == parent) {
                continue;
            }
            childTime = traversal(child, node, adjList, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}