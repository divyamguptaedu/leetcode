import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/*
Given an array of tree nodes, each node has left & right pointers, and each pointer is guaranteed to point to either:
null or a node in the array.
Write a function to determine if this array forms exactly 1 single binary tree. If so return root, otherwise return null.
Here is an example of a  Binary tree
       a
      / \
     b   c
    / \   \
   d   e   f

TreeNode f = new TreeNode (null, null);
TreeNode d = new TreeNode (null, null);
TreeNode e = new TreeNode (null, null);
TreeNode b = new TreeNode (d, e);
TreeNode c = new TreeNode (null, f);
TreeNode a = new TreeNode (b, c);

new Array[b, d, f, a, c, e]

childSet: d, e, b, c, d
 */

class TreeNode {
    TreeNode left;
    TreeNode right;

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeValidator {
    public static TreeNode isValid(TreeNode[] input) {
        // Check on the empty input
        if (input == null || input.length == 0) return null;

        // Step 1: Get the root node
        HashSet<TreeNode> childSet = new HashSet<>();
        for (TreeNode node : input) {
            if (node.left != null) childSet.add(node.left);
            if (node.right != null) childSet.add(node.right);
        }

        TreeNode root = null;

        for (TreeNode node : input) {
            if (!childSet.contains(node)) {
                if (root != null) {
                    return null;
                }
                root = node;
            }
        }

        if (root == null) return null;

        // Step 2: Check if there is a loop by traversing and add all descendants of root to a visited set.
        HashSet<TreeNode> visited = new HashSet<>();
        if (!dfs(root, visited)) return null;

        // Step 3: Check if we got all nodes in a single tree.
        if (visited.size() == input.length) {
            return root;
        } else {
            return null;
        }
    }

    private static boolean dfs(TreeNode node, HashSet<TreeNode> visited) {
        if (node == null) return true;
        if (visited.contains(node)) return false; //cycle detected, return false
        visited.add(node); //add to the visited set
        if (!dfs(node.left, visited)) {
            return false;
        }
        if (!dfs(node.right, visited)) {
            return false;
        }
        return true;
    }
}

class BinaryTreeValidatorTest {

    @Test
    public void generalCaseTest() {
        TreeNode f = new TreeNode (null, null);
        TreeNode d = new TreeNode (null, null);
        TreeNode e = new TreeNode (null, null);
        TreeNode b = new TreeNode (d, e);
        TreeNode c = new TreeNode (null, f);
        TreeNode a = new TreeNode (b, c);

        TreeNode[] input = new TreeNode[] {b, d, f, a, c, e};
        TreeNode result = BinaryTreeValidator.isValid(input);
        assertEquals(result, a);
    }

    @Test
    public void noRootCaseTest() {
        TreeNode f = new TreeNode (null, null);
        TreeNode d = new TreeNode (null, null);
        TreeNode e = new TreeNode (null, null);

        TreeNode[] input = new TreeNode[] {d, f, e};
        TreeNode result = BinaryTreeValidator.isValid(input);
        assertNull(result);
    }

    @Test
    public void leftSkewedCaseTest() {
        TreeNode f = new TreeNode (null, null);
        TreeNode d = new TreeNode (f, null);
        TreeNode e = new TreeNode (d, null);

        TreeNode[] input = new TreeNode[] {d, f, e};
        TreeNode result = BinaryTreeValidator.isValid(input);
        assertEquals(result, e);
    }

    @Test
    public void cycleCaseTest() {
        TreeNode f = new TreeNode (null, null);
        TreeNode d = new TreeNode (f, null);
        TreeNode e = new TreeNode (d, null);
        f.left = e;

        TreeNode[] input = new TreeNode[] {d, f, e};
        TreeNode result = BinaryTreeValidator.isValid(input);
        assertNull(result);
    }

    @Test
    public void nullTest() {
        TreeNode[] input = null;
        TreeNode result = BinaryTreeValidator.isValid(input);
        assertNull(result);
    }

    @Test
    public void emptyTest() {
        TreeNode[] input = new TreeNode[0];
        TreeNode result = BinaryTreeValidator.isValid(input);
        assertNull(result);
    }

    @Test
    public void singleNodeTest() {
        TreeNode f = new TreeNode (null, null);
        TreeNode[] input = new TreeNode[] {f};
        TreeNode result = BinaryTreeValidator.isValid(input);
        assertEquals(result, f);
    }
}
