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

    public int countGreatEnoughNodes(TreeNode root, int k) {
        if (root == null || k <= 0) return 0;

        Map<TreeNode, Integer> subtreeSizes = new HashMap<>();
        Map<TreeNode, List<Integer>> subtreeValues = new HashMap<>();
        dfs(root, subtreeSizes, subtreeValues);

        int count = 0;
        for (TreeNode node : subtreeSizes.keySet()) {
            int subtreeSize = subtreeSizes.get(node);
            if (subtreeSize >= k) {
                long smallerCount = subtreeValues.get(node).stream().filter(value -> value < node.val).count();
                if (smallerCount >= k) {
                    count++;
                }
            }
        }

        return count;
    }

    private int dfs(TreeNode node, Map<TreeNode, Integer> subtreeSizes, Map<TreeNode, List<Integer>> subtreeValues) {
        if (node == null) return 0;

        List<Integer> values = new ArrayList<>();
        values.add(node.val);
        int leftSize = dfs(node.left, subtreeSizes, subtreeValues);
        int rightSize = dfs(node.right, subtreeSizes, subtreeValues);

        values.addAll(subtreeValues.getOrDefault(node.left, Collections.emptyList()));
        values.addAll(subtreeValues.getOrDefault(node.right, Collections.emptyList()));

        subtreeSizes.put(node, leftSize + rightSize + 1);
        subtreeValues.put(node, values);

        return leftSize + rightSize + 1;
    }
}

class SolutionTwoTest {

    private SolutionTwo solution = new SolutionTwo();

    // Helper method to create a tree from a list of node values
    private TreeNode createTree(Integer[] values) {
        if (values.length == 0) return null;

        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                nodes[i] = new TreeNode(values[i]);
            }
        }

        for (int i = 0; i < values.length; i++) {
            if (nodes[i] != null) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                if (leftIndex < values.length && nodes[leftIndex] != null) {
                    nodes[i].left = nodes[leftIndex];
                }
                if (rightIndex < values.length && nodes[rightIndex] != null) {
                    nodes[i].right = nodes[rightIndex];
                }
            }
        }
        return nodes[0];
    }

    @Test
    void testCountGreatEnoughNodes() {
        TreeNode root = createTree(new Integer[]{7,6,5,4,3,2,1});
        int k = 2;
        int result = solution.countGreatEnoughNodes(root, k);
        assertEquals(3, result);

        root = createTree(new Integer[]{1,2,3});
        k = 1;
        result = solution.countGreatEnoughNodes(root, k);
        assertEquals(0, result);
    }

    @Test
    void testSingleNodeTree() {
        TreeNode root = createTree(new Integer[]{1});
        int k = 1;
        int result = solution.countGreatEnoughNodes(root, k);
        assertEquals(0, result);
    }

    @Test
    void testTreeWithAllNodesHavingSameValue() {
        TreeNode root = createTree(new Integer[]{5,5,5,5,5,5,5});
        int k = 3;
        int result = solution.countGreatEnoughNodes(root, k);
        assertEquals(0, result);
    }

    @Test
    void testEmptyTree() {
        TreeNode root = null;
        int k = 1;
        int result = solution.countGreatEnoughNodes(root, k);
        assertEquals(0, result);
    }
}