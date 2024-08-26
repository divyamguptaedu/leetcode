import java.util.*;

class KruskalAlgorithm {
    private int numVertices;
    private List<Edge> edges;

    public KruskalAlgorithm(int numVertices) {
        this.numVertices = numVertices;
        edges = new ArrayList<>();
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public void kruskalMST() {
        // Sort edges by weight
        Collections.sort(edges);

        // Initialize connected components, each vertex is its own component
        List<Set<Integer>> components = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            Set<Integer> component = new HashSet<>();
            component.add(i);
            components.add(component);
        }

        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;

        for (Edge edge : edges) {
            int srcComponent = findComponent(components, edge.src);
            int destComponent = findComponent(components, edge.dest);

            // If src and dest are in different components, add edge to MST
            if (srcComponent != destComponent) {
                mst.add(edge);
                mstWeight += edge.weight;
                // Merge the two components
                components.get(srcComponent).addAll(components.get(destComponent));
                // Remove the merged component
                components.remove(destComponent);
            }

            // If MST has n-1 edges, stop the algorithm
            if (mst.size() == numVertices - 1) {
                break;
            }
        }

        // Print the MST
        System.out.println("Kruskal's Algorithm Without Union-Find: Minimum Spanning Tree (MST)");
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.src + " - " + edge.dest + " | Weight: " + edge.weight);
        }
        System.out.println("Total Weight: " + mstWeight);
    }

    private int findComponent(List<Set<Integer>> components, int vertex) {
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).contains(vertex)) {
                return i;
            }
        }
        return -1;  // Should never happen if vertices are valid
    }

    // Helper class to represent an edge
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) {
        KruskalAlgorithm graph = new KruskalAlgorithm(6);

        // Add edges (undirected)
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 4, 3);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 3);

        // Find the MST using Kruskal's algorithm without Union-Find
        graph.kruskalMST();
    }
}

class PrimAlgorithm {
    private int numVertices;
    private List<List<Node>> adjList;

    public PrimAlgorithm(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Node(dest, weight));
        adjList.get(dest).add(new Node(src, weight));  // Undirected graph
    }

    public void primMST() {
        boolean[] inMST = new boolean[numVertices];
        int[] key = new int[numVertices];
        int[] parent = new int[numVertices];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(numVertices, Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(0, key[0]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            inMST[u] = true;

            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Node(v, key[v]));
                    parent[v] = u;
                }
            }
        }

        // Print the MST
        System.out.println("Prim's Algorithm: Minimum Spanning Tree (MST)");
        int totalWeight = 0;
        for (int i = 1; i < numVertices; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " | Weight: " + key[i]);
            totalWeight += key[i];
        }
        System.out.println("Total Weight: " + totalWeight);
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
        PrimAlgorithm graph = new PrimAlgorithm(6);

        // Add edges (undirected)
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 4, 3);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 3);

        // Find the MST using Prim's algorithm
        graph.primMST();
    }
}
