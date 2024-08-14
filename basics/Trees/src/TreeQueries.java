import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

//You are given a root to a binary tree and an integer k. A node of this tree is called great enough if the followings hold:
//Its subtree has at least k nodes.
//Its value is greater than the value of at least k nodes in its subtree.
//Return the number of nodes in this tree that are great enough.
//
//The node u is in the subtree of the node v, if u == v or v is an ancestor of u.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SolutionTwo {
    Integer greatCount = 0; // Tracks the count of "great" nodes

    public int countGreatEnoughNodes(TreeNode node, int k) {
        dfs(node, k);
        return greatCount; // Return the final count of "great" nodes
    }

    private List<Integer> dfs(TreeNode currentNode, int threshold) {
        if (currentNode == null) {
            return new ArrayList<>(); // Base case: return an empty list for null nodes
        }

        List<Integer> leftSubtree = dfs(currentNode.left, threshold);
        List<Integer> rightSubtree = dfs(currentNode.right, threshold);

        // Max heap to keep track of the top k largest values
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Combine values from left and right subtrees while maintaining the heap size
        for (int value : leftSubtree) {
            maxHeap.offer(value);
            if (maxHeap.size() > threshold) {
                maxHeap.poll();
            }
        }
        for (int value : rightSubtree) {
            maxHeap.offer(value);
            if (maxHeap.size() > threshold) {
                maxHeap.poll();
            }
        }

        // Check if the current node is "great" based on the heap's top value
        if (maxHeap.size() == threshold && currentNode.val > maxHeap.peek()) {
            greatCount++;
        }

        maxHeap.offer(currentNode.val);
        if (maxHeap.size() > threshold) {
            maxHeap.poll();
        }

        return new ArrayList<>(maxHeap);
    }
}

class SolutionTwoTest {
    SolutionTwo solution;
    @BeforeEach
    void setup() {
        solution = new SolutionTwo();
    }
    @Test
    void testExampleCase() {
        // Tree: [7,6,5,4,3,2,1]
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(6);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(1);

        // k = 2, nodes with values 7, 6, and 5 are "great enough"
        assertEquals(3, solution.countGreatEnoughNodes(root, 2));
    }

    @Test
    void testSingleNode() {
        // Tree: [10]
        TreeNode root = new TreeNode(10);

        // k = 1, the single node is not "great enough" since its value is not greater than any other node in its subtree (itself only)
        assertEquals(0, solution.countGreatEnoughNodes(root, 1));

        // k = 2, not enough nodes in the subtree
        assertEquals(0, solution.countGreatEnoughNodes(root, 2));
    }

    @Test
    void testTwoNodes() {
        // Tree: [8,3]
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);

        // k = 1, the root node (8) is "great enough" because its value is greater than the single value (3) in its subtree
        assertEquals(1, solution.countGreatEnoughNodes(root, 1));

        // k = 2, root (8) has a subtree size of 2, and its value is greater than 1 value (3) in its subtree
        assertEquals(1, solution.countGreatEnoughNodes(root, 2));
    }

    @Test
    void testUnbalancedTree() {
        // Tree: [5,4,null,3,null,2,null,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.left = new TreeNode(1);

        // k = 2, nodes with values 5, 4, and 3 are "great enough"
        assertEquals(3, solution.countGreatEnoughNodes(root, 2));
    }

    @Test
    void testBalancedTree() {
        // Tree: [10,5,15,3,7,13,20]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(20);

        // k = 3, nodes 10 is the only node "great enough"
        assertEquals(1, solution.countGreatEnoughNodes(root, 3));
    }

    @Test
    void testEmptyTree() {
        // Empty tree
        TreeNode root = null;

        // k = 1, no nodes in the tree
        assertEquals(0, solution.countGreatEnoughNodes(root, 1));
    }

    @Test
    void testLargeKValue() {
        // Tree: [7,6,5,4,3,2,1]
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(6);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(1);

        // k = 10, k is larger than the number of nodes in any subtree, so no node is "great enough"
        assertEquals(0, solution.countGreatEnoughNodes(root, 10));
    }
}