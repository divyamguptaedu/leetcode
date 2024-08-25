import java.util.*;

class DijkstraAlgorithm {
    private int numVertices;
    private List<List<Node>> adjList;

    public DijkstraAlgorithm(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Node(dest, weight));
    }

    public void dijkstra(int startVertex) {
        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(numVertices, Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(startVertex, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;
                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        // Print the shortest paths
        System.out.println("Dijkstra's Algorithm: (Shortest paths from vertex " + startVertex + ")");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + " : Distance " + distances[i]);
        }
    }

    // Helper class to represent a node in the graph
    static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        DijkstraAlgorithm graph = new DijkstraAlgorithm(6);

        // Add edges (directed)
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        // Find shortest paths from vertex 0
        graph.dijkstra(0);
    }
}

class BellmanFordAlgorithm {
    private int numVertices;
    private List<Edge> edgeList;

    public BellmanFordAlgorithm(int numVertices) {
        this.numVertices = numVertices;
        edgeList = new ArrayList<>();
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        edgeList.add(new Edge(src, dest, weight));
    }

    public void bellmanFord(int startVertex) {
        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        // Relax edges |V|-1 times
        for (int i = 1; i < numVertices; i++) {
            for (Edge edge : edgeList) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;
                if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edgeList) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                System.out.println("Graph contains a negative-weight cycle");
                return;
            }
        }

        // Print the shortest paths
        System.out.println("Bellman-Ford Algorithm: (Shortest paths from vertex " + startVertex + ")");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + " : Distance " + distances[i]);
        }
    }

    // Helper class to represent an edge in the graph
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        BellmanFordAlgorithm graph = new BellmanFordAlgorithm(5);

        // Add edges (directed)
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        // Find shortest paths from vertex 0
        graph.bellmanFord(0);
    }
}
