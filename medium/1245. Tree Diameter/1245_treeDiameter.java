//Very similar approach to 1522. First converted the edges list to adjancency list and visited list. 
//Used DFS on the N-Ary tree,  calculated the height of the nodes, and kept the maximumHeight and nextMaximumHeight updated. 
//Added them together to keep track of the maxDiameter.
class Solution {
    private List<List<Integer>> graph;
    private Integer diameter = 0;

    public int treeDiameter(int[][] edges) {
        //create the adjacency list to run DFS on it.
        this.graph = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[edges.length + 1];
        for (int i = 0; i <= edges.length; i++) { //prepare the adjacency list and visited list
            this.graph.add(new ArrayList<Integer>());
            visited[i] = false;
        }
        for (int[] edge : edges) { //fill up the adjacency list
            int start = edge[0];
            int end = edge[1];
            this.graph.get(start).add(end);
            this.graph.get(end).add(start);
        }

        dfs(0, visited);
        return this.diameter;
    }

    /**
     * return the max distance
     *   starting from the 'curr' node to its the leaf nodes
     */
    private int dfs(int curr, boolean[] visited) {
        int maximumHeight = 0;
        int nextMaximumHeight = 0;

        visited[curr] = true;
        for (Integer neighbor : graph.get(curr)) {
            int currentHeight = 0;
            if (!visited[neighbor])
                currentHeight = 1 + this.dfs(neighbor, visited);

            if (currentHeight > maximumHeight) {
                nextMaximumHeight = maximumHeight;
                maximumHeight = currentHeight;
            } else if (currentHeight > nextMaximumHeight) {
                nextMaximumHeight = currentHeight;
            }
        }

        //check if we found a greater diameter
        this.diameter = Math.max(this.diameter, maximumHeight + nextMaximumHeight);

        return maximumHeight;
    }
}

class Solution {
    int diameter;
    HashMap<Integer, List<Integer>> adjList;
    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        adjList = new HashMap<>();
        for (int[] edge : edges) {
            if (!adjList.containsKey(edge[0])) {
                adjList.put(edge[0], new ArrayList<>());
            }
            adjList.get(edge[0]).add(edge[1]);
        }
        diameter = 0;
        height(edges[0][0]);
        return diameter;
    }

    private int height(int node) {
        if (!adjList.containsKey(node) || adjList.get(node).size() == 0) {
            return 0;
        }
        int maxHeight1 = 0;
        int maxHeight2 = 0;

        for (int child : adjList.get(node)) {
            int parentHeight = height(child) + 1;
            if (parentHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = parentHeight;
            } else if (parentHeight > maxHeight2) {
                maxHeight2 = parentHeight;
            }
            this.diameter = Math.max(diameter, maxHeight1 + maxHeight2);
        }

        return maxHeight1;
    }
}