import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

/*
**Description**

The exterior of a tree contains the nodes from the root to the left-most leaf, then the leaves in left to right order, then the nodes from the right-most leaf to the root.

Example input:

```
    4
   / \
  2   2
 / \    \
1   5    3
      \
       7
```
*
* 4
* \
*  2
*  \
*   3
* //result: 4, 3, 2

Expected print: [4, 2, 1, 7, 3, 2]
*
Edge cases:
* 1. Empty tree
* 2. Tree with one node
* 3. Skewed tree
*
Approach:
* 1. Get the root
* 2. Get the left boundary, excluding the root and the leaf node,
* 3. Get the leaf nodes,
* 4. Get the right boundary, reverse it. Exclude the root and the leaf node.
 */

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class TreeExterior {
    public static List<Integer> getBoundary(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }

        //Step 1. Get the root
        result.add(root.val);

        //Step 2. Get the left boundary
        Node currentNode = root.left;

        while (currentNode != null) {
            if (currentNode.left == null && currentNode.right == null) {
                break;
            }
            result.add(currentNode.val);
            if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        //Step 3. Get the leaf nodes
        currentNode = root;
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.add(currentNode);
        while (!nodeStack.isEmpty()) {
            Node current = nodeStack.pop();
            if ((current.left == null && current.right == null) && (current != root)) {
                result.add(current.val);
            }
            // I made an error here
//            if (current.right != null) {
//                nodeStack.add(current.left);
//            }
//            if (current.left != null) {
//                nodeStack.add(current.right);
//            }
            if (current.right != null) {
                nodeStack.add(current.right);
            }
            if (current.left != null) {
                nodeStack.add(current.left);
            }
        }

        //Step 4. Get the right boundary
        currentNode = root.right;
        Stack<Node> rightStack = new Stack<>();
        while (currentNode != null) {
            if (currentNode.left == null && currentNode.right == null) {
                break;
            }
            rightStack.add(currentNode);
            if (currentNode.right != null) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        while (!rightStack.isEmpty()) {
            result.add(rightStack.pop().val);
        }

        return result;
    }
}

class TreeExteriorTest {
    @Test
    void emptyTest() {
        List<Integer> result = TreeExterior.getBoundary(null);
        assertNull(result);
    }
    @Test
    void singleNodeTest() {
        List<Integer> result = TreeExterior.getBoundary(new Node(3));
        assertEquals(List.of(3), result);
    }
    @Test
    void skewedTreeTest() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        List<Integer> result = TreeExterior.getBoundary(root);
        assertEquals(List.of(1, 2, 3), result);
    }
    @Test
    void skewedTreeTest2() {
        Node root = new Node(4);
        root.right = new Node(2);
        root.right.right = new Node(3);
        List<Integer> result = TreeExterior.getBoundary(root);
        assertEquals(List.of(4, 3, 2), result);
    }
    @Test
    void generalTest() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.left.right.right = new Node(7);
        root.right.right = new Node(3);
        List<Integer> result = TreeExterior.getBoundary(root);
        assertEquals(List.of(4, 2, 1, 7, 3, 2), result);
    }
}