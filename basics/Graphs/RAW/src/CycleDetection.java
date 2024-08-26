import java.util.*;

class UndirectedGraph {
    private int numVertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public UndirectedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // Because the graph is undirected
    }

    // DFS utility function to detect cycle
    private boolean dfs(int v, boolean[] visited, int parent) {
        visited[v] = true;

        // Recur for all adjacent vertices
        for (Integer neighbor : adjList[v]) {
            // If the adjacent vertex is not visited, then recurse on it
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, v)) {
                    return true;
                }
            }
            // If an adjacent vertex is visited and is not parent, there is a cycle
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Function to detect cycle in the graph
    public boolean hasCycle() {
        boolean[] visited = new boolean[numVertices];

        // Call the DFS-based helper function to detect a cycle
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {  // Don't recur for already visited vertices
                if (dfs(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); // Adding a cycle here
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        if (graph.hasCycle()) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph doesn't contain a cycle");
        }
    }
}

class DirectedGraph {
    private int numVertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public DirectedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    // DFS utility function to detect cycle
    private boolean dfs(int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v]) {
            return true;  // If the node is in the recursion stack, a cycle exists
        }
        if (visited[v]) {
            return false;  // If the node is already visited, skip it
        }

        visited[v] = true;
        recStack[v] = true;  // Add to recursion stack

        // Recur for all adjacent vertices
        for (Integer neighbor : adjList[v]) {
            if (dfs(neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack[v] = false;  // Remove from recursion stack
        return false;
    }

    // Function to detect cycle in the graph
    public boolean hasCycle() {
        boolean[] visited = new boolean[numVertices];
        boolean[] recStack = new boolean[numVertices];

        // Call the DFS-based helper function to detect a cycle
        for (int i = 0; i < numVertices; i++) {
            if (dfs(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); // Adding a cycle here
        graph.addEdge(2, 3);

        if (graph.hasCycle()) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph doesn't contain a cycle");
        }
    }
}
