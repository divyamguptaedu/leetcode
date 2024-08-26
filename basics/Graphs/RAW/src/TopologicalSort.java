import java.util.*;

class Graph {
    private int numVertices; // Number of vertices
    private LinkedList<Integer>[] adjList; // Adjacency list representation

    // Constructor
    public Graph(int numVertices) {
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

    // DFS utility function to visit nodes and push them onto the stack
    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true; // Mark the current node as visited

        // Recur for all the vertices adjacent to this vertex
        for (Integer neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }

        // Push the current vertex to stack which stores the result
        stack.push(v);
    }

    // The function to do Topological Sort using DFS
    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];

        // Initialize all vertices as not visited
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        // Call the recursive helper function to store Topological Sort
        // starting from all vertices one by one
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print the contents of the stack which gives the topological order
        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a graph given in the above diagram
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Following is a Topological Sort of the given graph:");
        graph.topologicalSort();
    }
}
