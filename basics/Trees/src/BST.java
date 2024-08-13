import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BST {
    TreeNode root;

    // Constructor
    public BST() {
        this.root = null;
    }

    // Iterative insert method
    public void insertIterative(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (true) {
            parent = current;
            if (value < current.val) {
                current = current.left;
                if (current == null) {
                    parent.left = new TreeNode(value);
                    return;
                }
            } else if (value > current.val) {
                current = current.right;
                if (current == null) {
                    parent.right = new TreeNode(value);
                    return;
                }
            } else {
                // Value already exists, do nothing
                return;
            }
        }
    }

    // Recursive insert method
    public void insertRecursive(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.val) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.val) {
            node.right = insertRecursive(node.right, value);
        }

        return node;
    }

    // Iterative contains method
    public boolean containsIterative(int value) {
        TreeNode current = root;

        while (current != null) {
            if (value < current.val) {
                current = current.left;
            } else if (value > current.val) {
                current = current.right;
            } else {
                return true; // Value found
            }
        }

        return false; // Value not found
    }

    // Recursive contains method
    public boolean containsRecursive(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(TreeNode node, int value) {
        if (node == null) {
            return false;
        }

        if (value < node.val) {
            return containsRecursive(node.left, value);
        } else if (value > node.val) {
            return containsRecursive(node.right, value);
        } else {
            return true; // Value found
        }
    }

    List<Integer> result;
    // Helper method to print the BST (in-order)
    public List<Integer> inOrderTraversal(TreeNode root) {
        result = new ArrayList<>();
        inOrderTraversalHelper(root);
        return result;
    }

    private void inOrderTraversalHelper(TreeNode node) {
        if (node != null) {
            inOrderTraversalHelper(node.left);
            result.add(node.val);
            inOrderTraversalHelper(node.right);
        }
    }

    // Recursive method to check if tree is a BST
    public boolean isBSTRecursive(TreeNode root) {
        return isBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTRecursive(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) {
            return false;
        }
        return isBSTRecursive(node.left, min, node.val - 1) && isBSTRecursive(node.right, node.val + 1, max);
    }

    // Iterative method to check if tree is a BST
    public boolean isBSTIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> dfsStack = new Stack<>();
        TreeNode prev = null;
        TreeNode current = root;

        while (current != null || !dfsStack.isEmpty()) {
            while (current != null) {
                dfsStack.push(current);
                current = current.left;
            }
            current = dfsStack.pop();
            if (prev != null && current.val <= prev.val) {
                return false;
            }
            prev = current;
            current = current.right;
        }

        return true;
    }
}

class BSTTests {
    private BST bst;

    @BeforeEach
    public void setup() {
        bst = new BST();
    }

    @Test
    public void testInsertContainsInorder() {
        // Test insertion and contains
        bst.insertIterative(10);
        bst.insertIterative(5);
        bst.insertIterative(15);
        bst.insertIterative(3);
        bst.insertIterative(7);

        assertTrue(bst.containsIterative(10));
        assertTrue(bst.containsIterative(5));
        assertTrue(bst.containsIterative(15));
        assertTrue(bst.containsIterative(3));
        assertTrue(bst.containsIterative(7));
        assertFalse(bst.containsIterative(20));

        bst.insertRecursive(20);
        assertTrue(bst.containsRecursive(20));
        assertFalse(bst.containsRecursive(25));

        bst.insertRecursive(25);
        assertTrue(bst.containsRecursive(25));

        assertEquals(List.of(3, 5, 7, 10, 15, 20, 25), bst.inOrderTraversal(bst.root));
    }

    @Test
    public void testEdgeCases() {
        // Test edge cases
        // Insert into empty tree
        bst.insertIterative(5);
        assertTrue(bst.containsIterative(5));

        // Insert and search with recursive methods
        bst = new BST();
        bst.insertRecursive(5);
        assertTrue(bst.containsRecursive(5));

        // Insert duplicates (should not be inserted)
        bst.insertRecursive(5);
        assertTrue(bst.containsRecursive(5)); // Still should be present

        // Test contains on empty tree
        bst = new BST();
        assertFalse(bst.containsRecursive(10));
        assertFalse(bst.containsIterative(10));
    }

    @Test
    public void testIsBST() {
        // Test empty tree
        assertTrue(bst.isBSTIterative(null));
        assertTrue(bst.isBSTRecursive(null));

        // Test single node
        assertTrue(bst.isBSTIterative(new TreeNode(4)));
        assertTrue(bst.isBSTRecursive(new TreeNode(4)));

        // Test valid BST
        TreeNode valid = new TreeNode(7, new TreeNode(3), new TreeNode(10));
        assertTrue(bst.isBSTIterative(valid));
        assertTrue(bst.isBSTRecursive(valid));

        // Test invalid BST
        TreeNode invalid = new TreeNode(7, new TreeNode(8), new TreeNode(9));
        assertFalse(bst.isBSTIterative(invalid));
        assertFalse(bst.isBSTRecursive(invalid));

        // Rebuild valid BST
        bst = new BST();
        bst.insertIterative(10);
        bst.insertIterative(5);
        bst.insertIterative(15);
        assertTrue(bst.isBSTIterative(bst.root));
        assertTrue(bst.isBSTRecursive(bst.root));
    }
}