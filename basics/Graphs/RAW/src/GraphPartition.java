import java.util.*;

class GraphPartitionBFS {
    private int numVertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    public GraphPartitionBFS(int numVertices) {
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

    // Function to partition the graph into two subgraphs
    public void partitionGraph() {
        int[] partitions = new int[numVertices];
        Arrays.fill(partitions, -1); // -1 means unassigned to any partition

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // Start with the first vertex
        partitions[0] = 0; // Assign to partition 0

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer neighbor : adjList[node]) {
                if (partitions[neighbor] == -1) { // If unassigned, assign to the opposite partition
                    partitions[neighbor] = 1 - partitions[node];
                    queue.add(neighbor);
                }
            }
        }

        // Print out the partitions
        System.out.println("Partition 0: ");
        for (int i = 0; i < numVertices; i++) {
            if (partitions[i] == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nPartition 1: ");
        for (int i = 0; i < numVertices; i++) {
            if (partitions[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        GraphPartitionBFS graph = new GraphPartitionBFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("Graph Partitioning:");
        graph.partitionGraph();
    }
}

class GraphPartitionDFS {
    private int numVertices;
    private LinkedList<Integer>[] adjList;
    private int[] partitions;

    // Constructor
    public GraphPartitionDFS(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        partitions = new int[numVertices];
        Arrays.fill(partitions, -1); // Initialize partitions to -1 (unassigned)

        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // For undirected graph
    }

    // DFS to partition the graph
    private boolean dfsPartition(int node, int partition) {
        partitions[node] = partition;

        for (int neighbor : adjList[node]) {
            if (partitions[neighbor] == -1) { // If neighbor is unassigned, assign to opposite partition
                if (!dfsPartition(neighbor, 1 - partition)) {
                    return false; // If there's a conflict in partitioning, return false
                }
            } else if (partitions[neighbor] == partition) {
                return false; // Conflict detected: same partition assignment
            }
        }
        return true;
    }

    // Function to start partitioning the graph
    public boolean partitionGraph() {
        for (int i = 0; i < numVertices; i++) {
            if (partitions[i] == -1) { // If vertex is unvisited
                if (!dfsPartition(i, 0)) { // Start partitioning with partition 0
                    return false; // If partitioning fails, return false
                }
            }
        }
        return true;
    }

    // Function to print the partitions
    public void printPartitions() {
        System.out.println("Partition 0:");
        for (int i = 0; i < numVertices; i++) {
            if (partitions[i] == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nPartition 1:");
        for (int i = 0; i < numVertices; i++) {
            if (partitions[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        GraphPartitionDFS graph = new GraphPartitionDFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        if (graph.partitionGraph()) {
            System.out.println("Graph Partitioning:");
            graph.printPartitions();
        } else {
            System.out.println("Graph cannot be partitioned into two balanced subgraphs.");
        }
    }
}
