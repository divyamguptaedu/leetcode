import java.util.*;

class ConnectedComponents {
    private int numVertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public ConnectedComponents(int numVertices) {
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

    // DFS utility function to visit all vertices of a component
    private void dfs(int v, boolean[] visited, List<Integer> component) {
        visited[v] = true;
        component.add(v);

        // Recur for all adjacent vertices
        for (Integer neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, component);
            }
        }
    }

    // Function to find and print all connected components
    public void findConnectedComponents() {
        boolean[] visited = new boolean[numVertices];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, visited, component);
                components.add(component);
            }
        }

        // Print the components and count
        System.out.println("Number of connected components: " + components.size());
        for (int i = 0; i < components.size(); i++) {
            System.out.println("Component " + (i + 1) + ": " + components.get(i));
        }
    }

    public static void main(String[] args) {
        ConnectedComponents graph = new ConnectedComponents(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);

        System.out.println("Connected components in the graph:");
        graph.findConnectedComponents();
    }
}
