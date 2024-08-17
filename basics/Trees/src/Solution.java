import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TreeNode {
    TreeNode left;
    TreeNode right;

    TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeValidator {

    public static TreeNode findBinaryTreeRoot(TreeNode[] nodes) {
        if (nodes == null || nodes.length == 0) return null;

        Set<TreeNode> childNodes = new HashSet<>();

        // Step 1: Track all child nodes
        for (TreeNode node : nodes) {
            if (node.left != null) childNodes.add(node.left);
            if (node.right != null) childNodes.add(node.right);
        }

        // Step 2: Identify the root node (a node that is not a child)
        TreeNode root = null;
        for (TreeNode node : nodes) {
            if (!childNodes.contains(node)) {
                if (root != null) {
                    // More than one root found, invalid tree
                    return null;
                }
                root = node;
            }
        }

        // Step 3: Check for single root
        if (root == null) {
            // No root found, invalid tree
            return null;
        }

        // Step 4: Check if all nodes are connected and there are no cycles
        Set<TreeNode> visited = new HashSet<>();
        if (!dfs(root, visited, null)) {
            return null; // Cycle detected or not all nodes are connected
        }

        // If all nodes are visited, the tree is valid
        return visited.size() == nodes.length ? root : null;
    }

    private static boolean dfs(TreeNode node, Set<TreeNode> visited, TreeNode parent) {
        if (node == null) return true;
        if (visited.contains(node)) return false; // Cycle detected

        visited.add(node);

        // Traverse left and right children, ensuring not to revisit the parent
        if (!dfs(node.left, visited, node) || !dfs(node.right, visited, node)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode f = new TreeNode(null, null);
        TreeNode d = new TreeNode(null, null);
        TreeNode e = new TreeNode(null, null);
        TreeNode b = new TreeNode(d, e);
        TreeNode c = new TreeNode(null, f);
        TreeNode a = new TreeNode(b, c);

        TreeNode[] nodes = new TreeNode[]{b, d, f, a, c, e};
        TreeNode root = findBinaryTreeRoot(nodes);

        if (root != null) {
            System.out.println("The array forms a single binary tree with root: " + root);
        } else {
            System.out.println("The array does not form a valid single binary tree.");
        }
    }
}

class BinaryTreeValidatorTest {

    @Test
    public void testValidBinaryTree() {
        TreeNode f = new TreeNode(null, null);
        TreeNode d = new TreeNode(null, null);
        TreeNode e = new TreeNode(null, null);
        TreeNode b = new TreeNode(d, e);
        TreeNode c = new TreeNode(null, f);
        TreeNode a = new TreeNode(b, c);

        TreeNode[] nodes = new TreeNode[]{b, d, f, a, c, e};
        TreeNode root = BinaryTreeValidator.findBinaryTreeRoot(nodes);
        assertEquals(a, root);
    }

    @Test
    public void testNoRoot() {
        TreeNode d = new TreeNode(null, null);
        TreeNode e = new TreeNode(null, null);
        TreeNode f = new TreeNode(null, null);

        TreeNode[] nodes = new TreeNode[]{d, e, f};
        TreeNode root = BinaryTreeValidator.findBinaryTreeRoot(nodes);
        assertNull(root);
    }

    @Test
    public void testMultipleRoots() {
        TreeNode g = new TreeNode(null, null);
        TreeNode h = new TreeNode(null, null);
        TreeNode d = new TreeNode(null, null);
        TreeNode e = new TreeNode(null, null);

        TreeNode[] nodes = new TreeNode[]{g, h, d, e};
        TreeNode root = BinaryTreeValidator.findBinaryTreeRoot(nodes);
        assertNull(root);
    }

    @Test
    public void testLoopInTree() {
        TreeNode i = new TreeNode(null, null);
        TreeNode j = new TreeNode(null, i);
        i.left = j; // Creates a loop

        TreeNode[] nodes = new TreeNode[]{i, j};
        TreeNode root = BinaryTreeValidator.findBinaryTreeRoot(nodes);
        assertNull(root);
    }

    @Test
    public void testSingleNodeTree() {
        TreeNode k = new TreeNode(null, null);

        TreeNode[] nodes = new TreeNode[]{k};
        TreeNode root = BinaryTreeValidator.findBinaryTreeRoot(nodes);
        assertEquals(k, root);
    }

    @Test
    public void testDisconnectedNodes() {
        TreeNode l = new TreeNode(null, null);
        TreeNode m = new TreeNode(null, null);
        TreeNode n = new TreeNode(null, l); // l and n are connected

        TreeNode[] nodes = new TreeNode[]{m, l, n};
        TreeNode root = BinaryTreeValidator.findBinaryTreeRoot(nodes);
        assertNull(root);
    }

    @Test
    public void testAllNodesHaveNoChildren() {
        TreeNode o = new TreeNode(null, null);
        TreeNode p = new TreeNode(null, null);
        TreeNode q = new TreeNode(null, null);

        TreeNode[] nodes = new TreeNode[]{o, p, q};
        TreeNode root = BinaryTreeValidator.findBinaryTreeRoot(nodes);
        assertNull(root);
    }

    @Test
    public void testLargerValidTree() {
        TreeNode r = new TreeNode(null, null);
        TreeNode s = new TreeNode(null, null);
        TreeNode t = new TreeNode(null, null);
        TreeNode u = new TreeNode(r, s);
        TreeNode v = new TreeNode(t, u);
        TreeNode w = new TreeNode(null, v);

        TreeNode[] nodes = new TreeNode[]{r, s, t, u, v, w};
        TreeNode root = BinaryTreeValidator.findBinaryTreeRoot(nodes);
        assertEquals(w, root);
    }
}
