import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
//You are given n BST (binary search tree) root nodes for n separate BSTs stored in an array trees (0-indexed). Each BST in trees has at most 3 nodes, and no two roots have the same value. In one operation, you can:
//
//Select two distinct indices i and j such that the value stored at one of the leaves of trees[i] is equal to the root value of trees[j].
//Replace the leaf node in trees[i] with trees[j].
//Remove trees[j] from trees.
//Return the root of the resulting BST if it is possible to form a valid BST after performing n - 1 operations, or null if it is impossible to create a valid BST.
//
//A BST (binary search tree) is a binary tree where each node satisfies the following property:
//
//Every node in the node's left subtree has a value strictly less than the node's value.
//Every node in the node's right subtree has a value strictly greater than the node's value.
//A leaf is a node that has no children.
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

class SolutionOne {
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> rootMap = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();

        // Populate rootMap and leafMap
        for (TreeNode tree : trees) {
            rootMap.put(tree.val, tree);
            if (tree.left != null) {
                leaves.add(tree.left.val);
            }
            if (tree.right != null) {
                leaves.add(tree.right.val);
            }
        }

        TreeNode rootTree = null;
        // Attempt to merge trees
        for (TreeNode tree : trees) {
            if (!leaves.contains(tree.val)) {
                if (rootTree != null) {
                    return null; // More than one root candidate, invalid BST
                }
                rootTree = tree;
            }
        }

        if (rootTree == null) return null;

        // Start merging
        if (!merge(rootTree, rootMap)) return null;

        // Check if all nodes are used
        if (rootMap.size() != 1) return null;

        // Check if the resulting tree is a valid BST
        if (!isValidBST(rootTree, Long.MIN_VALUE, Long.MAX_VALUE)) return null;

        return rootTree;
    }

    private boolean merge(TreeNode node, Map<Integer, TreeNode> rootMap) {
        if (node == null) return true;

        if (node.left != null && rootMap.containsKey(node.left.val)) {
            TreeNode leftSubTree = rootMap.get(node.left.val);
            node.left = leftSubTree;
            rootMap.remove(node.left.val);
            if (!merge(leftSubTree, rootMap)) return false;
        }

        if (node.right != null && rootMap.containsKey(node.right.val)) {
            TreeNode rightSubTree = rootMap.get(node.right.val);
            node.right = rightSubTree;
            rootMap.remove(node.right.val);
            if (!merge(rightSubTree, rootMap)) return false;
        }

        return true;
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}


// Test cases
class SolutionTest {

    private SolutionOne solution = new SolutionOne();

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    @Test
    void testValidMerge() {
        TreeNode t1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);

        List<TreeNode> trees = Arrays.asList(t1, t2, t3);
        TreeNode result = solution.canMerge(trees);

        assertNotNull(result);
        assertTrue(isValidBST(result, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    @Test
    void testInvalidMerge() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3, new TreeNode(1), new TreeNode(2));

        List<TreeNode> trees = Arrays.asList(t1, t2, t3);
        TreeNode result = solution.canMerge(trees);

        assertNull(result);
    }

    @Test
    void testSingleTree() {
        TreeNode t1 = new TreeNode(1);

        List<TreeNode> trees = Collections.singletonList(t1);
        TreeNode result = solution.canMerge(trees);

        assertNotNull(result);
        assertEquals(t1.val, result.val);
    }

    @Test
    void testInvalidMergeWithMultipleRoots() {
        TreeNode t1 = new TreeNode(1, new TreeNode(2), null);
        TreeNode t2 = new TreeNode(2, null, new TreeNode(3));
        TreeNode t3 = new TreeNode(3);

        List<TreeNode> trees = Arrays.asList(t1, t2, t3);
        TreeNode result = solution.canMerge(trees);

        assertNull(result);
    }

    @Test
    void testInvalidMergeWithDuplicateLeaves() {
        TreeNode t1 = new TreeNode(2, new TreeNode(1), null);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3, null, new TreeNode(1)); // Duplicate leaf 1

        List<TreeNode> trees = Arrays.asList(t1, t2, t3);
        TreeNode result = solution.canMerge(trees);

        assertNull(result);
    }
}