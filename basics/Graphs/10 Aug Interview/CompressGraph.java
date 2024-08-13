import java.util.*;

class Node {
    String data;
    List<Node> parents;
    List<Node> children;

    public Node(String data) {
        this.data = data;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }
}

public class CompressGraph {
    public Node compress(Node startNode) {
        if (startNode == null) return null;
        Node current = startNode;
        while (current != null) {
            List<Node> straightLine = new ArrayList<>();
            Node temp = current;
            while (temp != null && temp.children.size() == 1 && temp.children.get(0).parents.size() == 1) {
                straightLine.add(temp);
                temp = temp.children.get(0);
            }
            if (straightLine.size() > 1) {
                Node mergedNode = new Node(concatenateNodeData(straightLine));
                Node firstNode = straightLine.get(0);
                Node lastNode = straightLine.get(straightLine.size() - 1);
                for (Node parent : firstNode.parents) {
                    parent.children.remove(firstNode);
                    parent.children.add(mergedNode);
                    mergedNode.parents.add(parent);
                }
                for (Node child : lastNode.children) {
                    child.parents.remove(lastNode);
                    child.parents.add(mergedNode);
                    mergedNode.children.add(child);
                }
                current = lastNode.children.isEmpty() ? null : lastNode.children.get(0);
            } else {
                current = current.children.isEmpty() ? null : current.children.get(0);
            }
        }
        return startNode;
    }

    private String concatenateNodeData(List<Node> nodes) {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.data);
        }
        return sb.toString();
    }

    public void printGraph(Node startNode) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Node: " + current.data);
            System.out.print("  Parents: ");
            for (Node parent : current.parents) {
                System.out.print(parent.data + " ");
                if (!visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                }
            }
            System.out.println();
            System.out.print("  Children: ");
            for (Node child : current.children) {
                System.out.print(child.data + " ");
                if (!visited.contains(child)) {
                    queue.add(child);
                    visited.add(child);
                }
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        CompressGraph compressor = new CompressGraph();
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");

        A.children.add(D);
        B.children.add(D);
        C.children.add(D);
        D.parents.add(A);
        D.parents.add(B);
        D.parents.add(C);

        D.children.add(E);
        E.parents.add(D);

        E.children.add(F);
        F.parents.add(E);

        F.children.add(G);
        F.children.add(H);
        G.parents.add(F);
        H.parents.add(F);

        System.out.println("Graph before compression:");
        compressor.printGraph(A);

        Node compressedGraph = compressor.compress(A);

        System.out.println("Graph after compression:");
        compressor.printGraph(compressedGraph);
    }
}

