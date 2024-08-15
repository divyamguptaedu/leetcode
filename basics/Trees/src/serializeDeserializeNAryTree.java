import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class NAryTreeRecursive {
    private static final String NULL_NODE = "#";

    // Encodes an N-ary tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_NODE).append(",");
            return;
        }
        sb.append(node.val).append(",");
        sb.append(node.children.size()).append(",");
        for (Node child : node.children) {
            serializeHelper(child, sb);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private Node deserializeHelper(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals(NULL_NODE)) return null;

        int val = Integer.parseInt(value);
        int childrenCount = Integer.parseInt(queue.poll());
        Node node = new Node(val, new ArrayList<>());

        for (int i = 0; i < childrenCount; i++) {
            node.children.add(deserializeHelper(queue));
        }
        return node;
    }
}