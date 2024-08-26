import java.util.*;

class BipartiteGraph {
    private int numVertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public BipartiteGraph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // Because it's an undirected graph
    }

    // BFS-based function to check if the graph is bipartite
    public boolean isBipartite() {
        int[] colors = new int[numVertices];
        Arrays.fill(colors, -1); // -1 means uncolored

        for (int i = 0; i < numVertices; i++) {
            if (colors[i] == -1) { // If the vertex is uncolored
                if (!bfsCheck(i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper function to perform BFS
    private boolean bfsCheck(int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1; // Start coloring with 1

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer neighbor : adjList[node]) {
                if (colors[neighbor] == -1) { // If uncolored, color with the opposite color
                    colors[neighbor] = 1 - colors[node];
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) { // If the same color, not bipartite
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph graph = new BipartiteGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        if (graph.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}

class BipartiteGraphDFS {
    private int numVertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public BipartiteGraphDFS(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // Because it's an undirected graph
    }

    // DFS-based function to check if the graph is bipartite
    public boolean isBipartite() {
        int[] colors = new int[numVertices];
        Arrays.fill(colors, -1); // -1 means uncolored

        for (int i = 0; i < numVertices; i++) {
            if (colors[i] == -1) { // If the vertex is uncolored
                if (!dfsCheck(i, 1, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper function to perform DFS
    private boolean dfsCheck(int node, int color, int[] colors) {
        colors[node] = color;

        for (Integer neighbor : adjList[node]) {
            if (colors[neighbor] == -1) { // If uncolored, color with the opposite color
                if (!dfsCheck(neighbor, 1 - color, colors)) {
                    return false;
                }
            } else if (colors[neighbor] == colors[node]) { // If the same color, not bipartite
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraphDFS graph = new BipartiteGraphDFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        if (graph.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
