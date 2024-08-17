import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node (int val) {
        this.val = val;
        this.left = null;
       	this.right = null;
       	this.next = null;
    }
}

class AddNextPointers {

    public static void connectNodesAtSameLevel(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node current = nodesQueue.poll();

                if (prev != null) {
                    prev.next = current;
                }
                prev = current;

                if (current.left != null) {
                    nodesQueue.add(current.left);
                }
                if (current.right != null) {
                    nodesQueue.add(current.right);
                }
            }
            // End of level
            // Last node should point to null 'X'
            if (prev != null) {
                prev.next = null;
            }
        }
    }
}

class AddNextPointersTest {

    @Test
    void testEmptyTree() {
        Node root = null;
        AddNextPointers.connectNodesAtSameLevel(root);
        assertNull(root);
    }

    @Test
    void testSingleNode() {
        Node root = new Node(1);
        AddNextPointers.connectNodesAtSameLevel(root);
        assertNull(root.next);
    }

    @Test
    void testTwoLevels() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        AddNextPointers.connectNodesAtSameLevel(root);

        assertNull(root.next);
        assertEquals(root.right, root.left.next);
        assertNull(root.right.next);
    }

    @Test
    void testMultipleLevels() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        AddNextPointers.connectNodesAtSameLevel(root);

        assertNull(root.next);
        assertEquals(root.right, root.left.next);
        assertEquals(root.left.left.next, root.left.right);
        assertEquals(root.left.right.next, root.right.left);
        assertEquals(root.right.left.next, root.right.right);
        assertNull(root.right.right.next);
    }

    @Test
    void testUnbalancedTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(5);
        AddNextPointers.connectNodesAtSameLevel(root);

        assertNull(root.next);
        assertEquals(root.right, root.left.next);
        assertNull(root.right.next);
        assertNull(root.left.left.next);
        assertNull(root.left.left.left.next);
    }
}

