//Prepared the adjacency list, saved the list of leaf nodes, 
//removed the leaf nodes from the adjList along with the edges and then returned the remaining nodes.
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        //prepare adjacency list
        ArrayList<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            Integer start = edge[0];
            Integer end = edge[1];
            adjList.get(start).add(end);
            adjList.get(end).add(start);
        }

        //get leaf nodes
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        //remove the leaf nodes
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                Integer neighbor = adjList.get(leaf).iterator().next();
                adjList.get(neighbor).remove(leaf);
                if (adjList.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}