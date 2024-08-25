import java.util.*;

class AdjacencyMatrixGraph {
    private int[][] adjMatrix;
    private int numVertices;

    public AdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1; // For undirected graph
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0; // For undirected graph
    }

    public boolean hasEdge(int i, int j) {
        return adjMatrix[i][j] != 0;
    }
}

class AdjacencyListGraph {
    private List<List<Integer>> adjList;
    private int numVertices;

    public AdjacencyListGraph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // For undirected graph
    }

    public void removeEdge(int src, int dest) {
        adjList.get(src).remove((Integer) dest);
        adjList.get(dest).remove((Integer) src); // For undirected graph
    }

    public List<Integer> getNeighbors(int vertex) {
        return adjList.get(vertex);
    }
}


class EdgeListGraph {
    private List<int[]> edges;

    public EdgeListGraph() {
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest) {
        edges.add(new int[]{src, dest});
    }

    public void removeEdge(int src, int dest) {
        edges.removeIf(edge -> edge[0] == src && edge[1] == dest);
    }

    public List<int[]> getEdges() {
        return edges;
    }
}

class DirectedWeightedGraph {
    private int[][] adjMatrix;
    private int numVertices;

    public DirectedWeightedGraph(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];
    }

    // Add an edge from src to dest with a specific weight
    public void addEdge(int src, int dest, int weight) {
        adjMatrix[src][dest] = weight;
    }

    // Remove an edge from src to dest
    public void removeEdge(int src, int dest) {
        adjMatrix[src][dest] = 0;
    }

    // Get the weight of an edge from src to dest
    public int getEdge(int src, int dest) {
        return adjMatrix[src][dest];
    }

    // Update the weight of an edge from src to dest
    public void updateEdge(int src, int dest, int newWeight) {
        adjMatrix[src][dest] = newWeight;
    }

    // Display the adjacency matrix of the graph
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a directed weighted graph with 5 vertices
        DirectedWeightedGraph graph = new DirectedWeightedGraph(5);

        // Add edges to the graph
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 9);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 4);
        graph.addEdge(4, 0, 7); // Introducing a cycle

        // Display the graph
        graph.printGraph();

        // Read an edge's weight
        int weight = graph.getEdge(2, 3);
        System.out.println("\nWeight of edge from 2 to 3: " + weight);

        // Update the weight of an edge
        graph.updateEdge(2, 3, 15);
        System.out.println("\nUpdated weight of edge from 2 to 3:");
        graph.printGraph();

        // Remove an edge
        graph.removeEdge(1, 3);
        System.out.println("\nGraph after removing edge from 1 to 3:");
        graph.printGraph();
    }
}
