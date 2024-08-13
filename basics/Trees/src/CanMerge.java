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
    int nodeCount = 0;

    public TreeNode canMerge(List<TreeNode> trees) {
        // Convert List to array for easier manipulation
        int n = trees.size();
        if (n == 1) return trees.get(0);

        TreeNode[] treeArray = new TreeNode[n];
        trees.toArray(treeArray);

        // Initialize mappings
        Map<Integer, TreeNode> leafToTreeMap = new HashMap<>();
        Map<Integer, TreeNode> rootToTreeMap = new HashMap<>();
        int maxValue = 0;

        // Populate the maps and find the maximum node value
        for (TreeNode tree : treeArray) {
            rootToTreeMap.put(tree.val, tree);
            if (tree.val > maxValue) maxValue = tree.val;
            if (tree.left != null) {
                if (tree.left.val > maxValue) maxValue = tree.left.val;
                leafToTreeMap.put(tree.left.val, tree);
            }
            if (tree.right != null) {
                if (tree.right.val > maxValue) maxValue = tree.right.val;
                leafToTreeMap.put(tree.right.val, tree);
            }
        }

        // Attempt to merge trees based on leaf and root mappings
        TreeNode rootTree = null;
        for (TreeNode tree : treeArray) {
            if (leafToTreeMap.containsKey(tree.val)) {
                TreeNode parentTree = leafToTreeMap.get(tree.val);
                if (parentTree.left != null && parentTree.left.val == tree.val) {
                    parentTree.left = tree;
                } else {
                    parentTree.right = tree;
                }
                nodeCount++;
            } else {
                if (rootTree != null) {
                    return null; // More than one possible root, invalid BST
                }
                rootTree = tree;
            }
        }

        // Check if all nodes are used and if the resulting tree is a valid BST
        if (nodeCount != n - 1 || rootTree == null) return null;
        if (!isValidBST(rootTree, Long.MIN_VALUE, Long.MAX_VALUE)) return null;

        return rootTree;
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