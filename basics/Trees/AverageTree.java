import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

/*
Given a binary tree check if each node is the average of all its descendants (direct and indirect).

Approach:
1. Traverse in post order manner (left, right, node). Keep the subtree Sum and count of nodes.
2. Check the condition: sum / count == current.val. If false, stop! Return false; Otherwise, continue.

==== Returns True ====
        2
       / \
      2   2
     /   / \
    2   1   3
=====================

==== Returns False ====
        3
       / \
      2   4
     /   / \
    2   3   5
=====================

Edge Cases:
1. Single Node
2. Empty
3. general
 */

class Node {
    double val;
    Node left;
    Node right;

    public Node(double val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Node(double val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class AverageTree {
    public static boolean checkIfAverage(Node root) {
        if (root == null) return false;
        return checkIfAverageHelper(root)[2] == 1.0;
    }

    private static double[] checkIfAverageHelper(Node node) {
        if (node == null) return new double[] {0, 0, 1.0};

        //Step 1: Post order traversal
        double[] left = checkIfAverageHelper(node.left);
        double[] right = checkIfAverageHelper(node.right);

        double sum = left[0] + right[0];
        double count = left[1] + right[1];

        //Step 2: Check if the current node's value equals the average of its descendants
        boolean isAverage = (count > 1 && node.val == sum / count) || (count <= 1);

        // Return {sum, count, isAverageFlag}
        return new double[] {sum + node.val, count + 1, isAverage ? 1.0 : 0.0};
    }
}

class AverageTreeTest {
    @Test
    void singleNodeTest() {
        Node root = new Node(1);
        assertEquals(true, AverageTree.checkIfAverage(root));
    }

    @Test
    void emptyTest() {
        assertEquals(false, AverageTree.checkIfAverage(null));
    }

    @Test
    void generalTest1() {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(2);
        root.right.left = new Node(3);
        root.right.right = new Node(5);
        assertEquals(false, AverageTree.checkIfAverage(root));
    }

    @Test
    void generalTest2() {
        Node root = new Node(2);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.right.left = new Node(1);
        root.right.right = new Node(3);
        assertEquals(true, AverageTree.checkIfAverage(root));
    }
}
