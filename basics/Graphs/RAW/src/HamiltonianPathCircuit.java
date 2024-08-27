import java.util.*;

class HamiltonianPathCircuit {
    private int numVertices;
    private int[][] graph;
    private boolean[] visited;
    private List<Integer> path;

    // Constructor
    public HamiltonianPathCircuit(int numVertices) {
        this.numVertices = numVertices;
        graph = new int[numVertices][numVertices];
        visited = new boolean[numVertices];
        path = new ArrayList<>();
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest) {
        graph[src][dest] = 1;
        graph[dest][src] = 1; // Since it's an undirected graph
    }

    // Check if there is a Hamiltonian Circuit starting from a given vertex
    public boolean findHamiltonianCircuit(int startVertex) {
        path.add(startVertex);
        visited[startVertex] = true;

        if (findHamiltonianPath(startVertex)) {
            // Check if the path forms a circuit by returning to the start vertex
            if (graph[path.get(path.size() - 1)][startVertex] == 1) {
                path.add(startVertex);
                return true;
            }
        }

        path.remove(path.size() - 1);
        visited[startVertex] = false;
        return false;
    }

    // Recursive helper function to find Hamiltonian Path
    private boolean findHamiltonianPath(int currentVertex) {
        // If the path includes all vertices, return true
        if (path.size() == numVertices) {
            return true;
        }

        for (int nextVertex = 0; nextVertex < numVertices; nextVertex++) {
            // Check if the next vertex is connected and not visited
            if (graph[currentVertex][nextVertex] == 1 && !visited[nextVertex]) {
                path.add(nextVertex);
                visited[nextVertex] = true;

                if (findHamiltonianPath(nextVertex)) {
                    return true;
                }

                // Backtrack
                path.remove(path.size() - 1);
                visited[nextVertex] = false;
            }
        }

        return false;
    }

    public void printHamiltonianPathOrCircuit() {
        if (path.size() == numVertices + 1) {
            System.out.println("Hamiltonian Circuit found:");
        } else if (path.size() == numVertices) {
            System.out.println("Hamiltonian Path found:");
        } else {
            System.out.println("No Hamiltonian Path or Circuit found.");
            return;
        }

        for (int vertex : path) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HamiltonianPathCircuit graph = new HamiltonianPathCircuit(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        if (!graph.findHamiltonianCircuit(0)) {
            graph.printHamiltonianPathOrCircuit();
        } else {
            graph.printHamiltonianPathOrCircuit();
        }
    }
}
