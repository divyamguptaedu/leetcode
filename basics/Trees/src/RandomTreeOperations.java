import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class RandomTreeOperations {

    // Method to swap the left and right children of every node in the tree
    public TreeNode swapChildren(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right children of the current node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively swap the children of the left and right subtrees
        swapChildren(root.left);
        swapChildren(root.right);
        return root;
    }

    public TreeNode mirrorImageOfTree(TreeNode root) {
        return swapChildren(root);
    }
}

class RandomTreeMethodsTests {
    private RandomTreeOperations randomTreeOperations;
    private TreeNode root;

    @BeforeEach
    public void setup() {
        randomTreeOperations = new RandomTreeOperations();

        // Create a sample tree
        root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);
    }

    @Test
    public void testSwapChildren() {
        // Swap children
        randomTreeOperations.swapChildren(root);

        // Check that the children of the root node are swapped
        assertEquals(10, root.left.val);
        assertEquals(3, root.right.val);

        assertEquals(14, root.left.left.val);
        assertEquals(null, root.left.right);
        assertEquals(6, root.right.left.val);
        assertEquals(1, root.right.right.val);

        assertEquals(13, root.left.left.right.val);
        assertEquals(null, root.left.left.left);
        assertEquals(4, root.right.left.right.val);
        assertEquals(7, root.right.left.left.val);
    }
}
