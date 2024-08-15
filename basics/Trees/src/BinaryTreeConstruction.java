import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeConstruction {
    public TreeNode root;

    public BinaryTreeConstruction() {
        this.root = null;
    }

    // Create methods
    // Iterative
    public void add(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left == null) {
                node.left = new TreeNode(value);
                return;
            } else {
                queue.add(node.left);
            }

            if (node.right == null) {
                node.right = new TreeNode(value);
                return;
            } else {
                queue.add(node.right);
            }
        }
    }

    // Recursive
    public void addRecursive(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            addRecursive(root, value);
        }
    }

    private void addRecursive(TreeNode node, int value) {
        if (node.left == null) {
            node.left = new TreeNode(value);
        } else if (node.right == null) {
            node.right = new TreeNode(value);
        } else {
            addRecursive(node.left, value);
        }
    }

    // Read methods
    // Iterative
    public List<Integer> inOrderTraversalIterative() {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }

    // Recursive
    public List<Integer> inOrderTraversalRecursive() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversalRecursive(root, result);
        return result;
    }

    private void inOrderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            inOrderTraversalRecursive(node.left, result);
            result.add(node.val);
            inOrderTraversalRecursive(node.right, result);
        }
    }

    // Update method
    // Iterative
    public boolean update(int oldValue, int newValue) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == oldValue) {
                node.val = newValue;
                return true;
            }

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }

    // Recursive
    public boolean updateRecursive(int oldValue, int newValue) {
        return updateRecursive(root, oldValue, newValue);
    }

    private boolean updateRecursive(TreeNode node, int oldValue, int newValue) {
        if (node == null) return false;

        if (node.val == oldValue) {
            node.val = newValue;
            return true;
        }

        return updateRecursive(node.left, oldValue, newValue) || updateRecursive(node.right, oldValue, newValue);
    }

    // Delete method
    // Iterative
    public boolean delete(int value) {
        if (root == null) {
            return false; // Tree is empty
        }

        // Case when the tree has only one node
        if (root.left == null && root.right == null) {
            if (root.val == value) {
                root = null;
                return true;
            } else {
                return false;
            }
        }

        // Perform level-order traversal to find the node to be deleted and the deepest node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode nodeToDelete = null;
        TreeNode deepestNode = null;
        TreeNode parentOfDeepestNode = null;

        while (!queue.isEmpty()) {
            deepestNode = queue.poll();

            if (deepestNode.left != null) {
                queue.add(deepestNode.left);
                parentOfDeepestNode = deepestNode;
            }

            if (deepestNode.right != null) {
                queue.add(deepestNode.right);
                parentOfDeepestNode = deepestNode;
            }

            // Find the node to be deleted
            if (deepestNode.val == value) {
                nodeToDelete = deepestNode;
            }
        }

        // Replace the value of the node to be deleted with the deepest node's value
        if (nodeToDelete != null) {
            nodeToDelete.val = deepestNode.val;

            // Remove the deepest node
            if (parentOfDeepestNode.right == deepestNode) {
                parentOfDeepestNode.right = null;
            } else {
                parentOfDeepestNode.left = null;
            }
            return true;
        }

        return false; // Node with the given value was not found
    }

    // Serialize the binary tree using preorder traversal
    public String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(node, sb);
        return sb.toString();
    }

    // Helper method for preorder serialization
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,"); // Use "#" to denote null nodes
            return;
        }
        sb.append(node.val).append(","); // Append node value
        serializeHelper(node.left, sb);  // Recursively serialize left subtree
        serializeHelper(node.right, sb); // Recursively serialize right subtree
    }

    // Deserialize the string to reconstruct the binary tree
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        for (String s : data.split(",")) {
            nodes.offer(s); // Split the data by comma and add to queue
        }
        return deserializeHelper(nodes);
    }

    // Helper method for deserialization
    private TreeNode deserializeHelper(Queue<String> nodes) {
        String value = nodes.poll(); // Get the next value from the queue
        if (value.equals("#")) {
            return null; // Return null for "#"
        }

        TreeNode node = new TreeNode(Integer.valueOf(value)); // Create node with the value
        node.left = deserializeHelper(nodes); // Recursively build left subtree
        node.right = deserializeHelper(nodes); // Recursively build right subtree
        return node;
    }
}

class BinaryTreeConstructionTest {
    private BinaryTreeConstruction tree;

    @BeforeEach
    public void setUp() {
        tree = new BinaryTreeConstruction();
    }

    @Test
    public void testAddIterative() {
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

        assertEquals(List.of(4, 2, 5, 1, 3), tree.inOrderTraversalIterative());
    }

    @Test
    public void testAddRecursive() {
        tree.addRecursive(1);
        tree.addRecursive(2);
        tree.addRecursive(3);
        tree.addRecursive(4);
        tree.addRecursive(5);

        assertEquals(List.of(4, 2, 5, 1, 3), tree.inOrderTraversalRecursive());
    }

    @Test
    public void testInOrderTraversalIterative() {
        tree.add(1);
        tree.add(2);
        tree.add(3);

        // Expect 2 1 3
        assertEquals(List.of(2, 1, 3), tree.inOrderTraversalIterative());
    }

    @Test
    public void testInOrderTraversalRecursive() {
        tree.add(1);
        tree.add(2);
        tree.add(3);

        // Expect 2 1 3
        assertEquals(List.of(2, 1, 3), tree.inOrderTraversalRecursive());
    }

    @Test
    public void testUpdateIterative() {
        tree.add(1);
        tree.add(2);
        tree.add(3);

        assertTrue(tree.update(2, 20));
        assertFalse(tree.update(10, 100));
        assertEquals(List.of(20, 1, 3), tree.inOrderTraversalIterative());
    }

    @Test
    public void testUpdateRecursive() {
        tree.add(1);
        tree.add(2);
        tree.add(3);

        assertTrue(tree.updateRecursive(2, 20));
        assertFalse(tree.updateRecursive(10, 100));
        assertEquals(List.of(20, 1, 3), tree.inOrderTraversalRecursive());
    }

    @Test
    public void testDeleteIterativeOne() {
        tree.add(1);
        tree.add(2);
        tree.add(3);

        assertTrue(tree.delete(1));
        assertEquals(List.of(2, 3), tree.inOrderTraversalIterative());
    }

    @Test
    public void testDeleteIterativeTwo() {
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);

        assertTrue(tree.delete(2));
        assertFalse(tree.delete(10));
        assertEquals(List.of(4, 1, 3), tree.inOrderTraversalIterative());
    }

    @Test
    public void testEmptyTree() {
        // Add to an empty tree
        tree.add(1);
        assertEquals(List.of(1), tree.inOrderTraversalRecursive());

        // Delete from an empty tree
        assertFalse(tree.delete(10));
    }

    @Test
    public void testSingleNode() {
        tree.add(1);
        assertTrue(tree.update(1, 10));
        assertEquals(List.of(10), tree.inOrderTraversalIterative());

        assertTrue(tree.delete(10));
        assertFalse(tree.delete(10)); // Delete again should fail
    }

    // Tests for Iterative Serialization and Deserialization
    @Test
    public void testSerializeIterative() {
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(5);

        String serialized = tree.serialize(tree.root);
        assertEquals("1,2,#,#,3,4,#,#,5,#,#,", serialized);
    }


    @Test
    public void testDeserialize() {
        String data = "1,2,#,#,3,4,#,#,5,#,#,";
        TreeNode deserializedRoot = tree.deserialize(data);

        // Verify the tree structure
        assertNotNull(deserializedRoot);
        assertEquals(1, deserializedRoot.val);
        assertNotNull(deserializedRoot.left);
        assertEquals(2, deserializedRoot.left.val);
        assertNotNull(deserializedRoot.right);
        assertEquals(3, deserializedRoot.right.val);
        assertNotNull(deserializedRoot.right.left);
        assertEquals(4, deserializedRoot.right.left.val);
        assertNotNull(deserializedRoot.right.right);
        assertEquals(5, deserializedRoot.right.right.val);
    }
}