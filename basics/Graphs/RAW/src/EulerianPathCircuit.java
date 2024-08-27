import java.util.*;

class EulerianPathCircuit {
    private int numVertices;
    private LinkedList<Integer>[] adjList;
    private LinkedList<Integer>[] originalAdjList;
    private int[] degree;

    // Constructor
    public EulerianPathCircuit(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        originalAdjList = new LinkedList[numVertices];
        degree = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
            originalAdjList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
        originalAdjList[src].add(dest);
        originalAdjList[dest].add(src);
        degree[src]++;
        degree[dest]++;
    }

    // Function to check if an Eulerian Path or Circuit exists
    public String checkEulerian() {
        int oddDegreeVertices = 0;
        for (int i = 0; i < numVertices; i++) {
            if (degree[i] % 2 != 0) {
                oddDegreeVertices++;
            }
        }

        if (oddDegreeVertices == 0) {
            return "Eulerian Circuit exists";
        } else if (oddDegreeVertices == 2) {
            return "Eulerian Path exists";
        } else {
            return "Neither Eulerian Path nor Eulerian Circuit exists";
        }
    }

    // Hierholzer's Algorithm to find the Eulerian Path or Circuit
    public List<Integer> findEulerianPathOrCircuit() {
        List<Integer> path = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int startVertex = 0;

        for (int i = 0; i < numVertices; i++) {
            if (degree[i] % 2 != 0) {
                startVertex = i;
                break;
            }
        }

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.peek();

            if (adjList[vertex].size() == 0) {
                path.add(vertex);
                stack.pop();
            } else {
                int neighbor = adjList[vertex].removeFirst();
                adjList[neighbor].remove((Integer) vertex);
                stack.push(neighbor);
            }
        }

        // Verify the path covers all edges
        for (int i = 0; i < numVertices; i++) {
            if (adjList[i].size() > 0) {
                return null; // Not all edges are covered, so it's not an Eulerian path/circuit
            }
        }

        return path;
    }

    public static void main(String[] args) {
        EulerianPathCircuit graph = new EulerianPathCircuit(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(3, 0);
        graph.addEdge(3, 5);

        System.out.println(graph.checkEulerian());
        List<Integer> eulerianPathOrCircuit = graph.findEulerianPathOrCircuit();
        if (eulerianPathOrCircuit != null) {
            System.out.println("Eulerian Path/Circuit:");
            for (int vertex : eulerianPathOrCircuit) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("No Eulerian Path/Circuit exists.");
        }
    }
}
