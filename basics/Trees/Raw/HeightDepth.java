import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HeightDepth {

    // Recursive method to find the height of a tree
    public int getHeightRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeightRecursive(root.left), getHeightRecursive(root.right));
    }

    // Iterative method to find the height of a tree
    public int getHeightIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        int height = 0;

        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = bfsQueue.poll();
                if (node.left != null) {
                    bfsQueue.offer(node.left);
                }
                if (node.right != null) {
                    bfsQueue.offer(node.right);
                }
            }
            height++;
        }

        return height;
    }

    // Recursive method to find the depth of a node given its value
    int result;
    public int getDepthRecursive(TreeNode root, int value) {
        if (root == null) {
            return -1;
        }
        result = -1;
        getDepthRecursiveHelper(root, value, 0);
        return result;
    }

    private void getDepthRecursiveHelper(TreeNode node, int value, int depth) {
        if (node.val == value) {
            result = depth;
            return;
        }
        if (node.left != null) {
            getDepthRecursiveHelper(node.left, value, depth + 1);
        }
        if (node.right != null) {
            getDepthRecursiveHelper(node.right, value, depth + 1);
        }
    }

    // Iterative method to find the depth of a node given its value
    public int getDepthIterative(TreeNode root, int value) {
        if (root == null) {
            return -1; // Value not found
        }
        Queue<Pair<TreeNode, Integer>> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Pair<>(root, 0));

        while (!bfsQueue.isEmpty()) {
            Pair<TreeNode, Integer> pair = bfsQueue.poll();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();

            if (node.val == value) {
                return depth;
            }
            if (node.left != null) {
                bfsQueue.offer(new Pair<>(node.left, depth + 1));
            }
            if (node.right != null) {
                bfsQueue.offer(new Pair<>(node.right, depth + 1));
            }
        }

        return -1; // Value not found
    }

}


class HeightDepthTests {
    private HeightDepth heightDepth;
    private TreeNode root;

    @BeforeEach
    public void setup() {
        heightDepth = new HeightDepth();

        // Regular tree
        //         8
        //       /   \
        //      3    10
        //    /   \    \
        //    1   6    14
        //       / \  /
        //      4  7 13
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
    public void testGetHeightRecursive() {
        assertEquals(4, heightDepth.getHeightRecursive(root));
    }

    @Test
    public void testGetHeightIterative() {
        assertEquals(4, heightDepth.getHeightIterative(root));
    }

    @Test
    public void testGetDepthRecursive() {
        assertEquals(0, heightDepth.getDepthRecursive(root, 8)); // Root node
        assertEquals(1, heightDepth.getDepthRecursive(root, 10)); // Direct child of root
        assertEquals(3, heightDepth.getDepthRecursive(root, 7));  // Grandchild of root
        assertEquals(-1, heightDepth.getDepthRecursive(root, 100)); // Non-existent node
    }

    @Test
    public void testGetDepthIterative() {
        assertEquals(0, heightDepth.getDepthIterative(root, 8)); // Root node
        assertEquals(1, heightDepth.getDepthIterative(root, 10)); // Direct child of root
        assertEquals(3, heightDepth.getDepthIterative(root, 7));  // Grandchild of root
        assertEquals(-1, heightDepth.getDepthIterative(root, 100)); // Non-existent node
    }
}
