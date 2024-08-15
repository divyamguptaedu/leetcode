//Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
// is the inorder traversal of the same tree, construct and return the binary tree.

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeFromPreorderInorder {
    private Map<Integer, Integer> inorderMap;  // Map to store the indices of elements in inorder array
    private int preorderIndex;  // Index for traversing the preorder array

    public TreeNode buildTreeRecursive(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        preorderIndex = 0;

        // Populate the inorderMap with the value-to-index mappings
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Start recursive construction of the tree
        return buildTreeRecursiveHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursiveHelper(int[] preorder, int left, int right) {
        // Base case: if the left index exceeds the right index, return null
        if (left > right) {
            return null;
        }

        // Get the root value from the preorder array and create a new node
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root value in the inorder array
        int inorderIndex = inorderMap.get(rootVal);

        // Recursively build the left and right subtrees
        root.left = buildTreeRecursiveHelper(preorder, left, inorderIndex - 1);
        root.right = buildTreeRecursiveHelper(preorder, inorderIndex + 1, right);

        return root;
    }

    public TreeNode buildTreeIterative(int[] preorder, int[] inorder) {
        // Handle edge cases where inputs are null or lengths are mismatched
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // Initialize a map to store the indices of elements in the inorder array
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Use a stack to build the tree iteratively
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);  // Create the root node
        stack.push(root);

        // Iterate through the preorder array to build the tree
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            int inorderIndex = inorderMap.get(preorder[i]);

            // Determine whether to add the node as a left or right child based on inorder indices
            if (inorderIndex < inorderMap.get(node.val)) {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && inorderMap.get(preorder[i]) > inorderMap.get(stack.peek().val)) {
                    node = stack.pop();
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }

        return root;
    }
}

class BinaryTreeFromPreorderInorderTest {

    @Test
    void testBuildTreeRecursive() {
        BinaryTreeFromPreorderInorder builder = new BinaryTreeFromPreorderInorder();

        // Example test case 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = builder.buildTreeRecursive(preorder1, inorder1);
        // Verify
        assertArrayEquals(new int[]{3, 9, 20, 15, 7}, preorderTraversal(root1));
        assertArrayEquals(new int[]{9, 3, 15, 20, 7}, inorderTraversal(root1));

        // Example test case 2
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode root2 = builder.buildTreeRecursive(preorder2, inorder2);
        // Verify
        assertArrayEquals(new int[]{-1}, preorderTraversal(root2));
        assertArrayEquals(new int[]{-1}, inorderTraversal(root2));
    }

    @Test
    void testBuildTreeIterative() {
        BinaryTreeFromPreorderInorder builder = new BinaryTreeFromPreorderInorder();

        // Example test case 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = builder.buildTreeIterative(preorder1, inorder1);
        // Verify
        assertArrayEquals(new int[]{3, 9, 20, 15, 7}, preorderTraversal(root1));
        assertArrayEquals(new int[]{9, 3, 15, 20, 7}, inorderTraversal(root1));

        // Example test case 2
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode root2 = builder.buildTreeIterative(preorder2, inorder2);
        // Verify
        assertArrayEquals(new int[]{-1}, preorderTraversal(root2));
        assertArrayEquals(new int[]{-1}, inorderTraversal(root2));
    }

    @Test
    void testEdgeCases() {
        BinaryTreeFromPreorderInorder builder = new BinaryTreeFromPreorderInorder();

        // Edge case: Single node tree
        int[] preorderSingle = {1};
        int[] inorderSingle = {1};
        TreeNode rootSingleRecursive = builder.buildTreeRecursive(preorderSingle, inorderSingle);
        TreeNode rootSingleIterative = builder.buildTreeIterative(preorderSingle, inorderSingle);
        // Verify
        assertArrayEquals(new int[]{1}, preorderTraversal(rootSingleRecursive));
        assertArrayEquals(new int[]{1}, inorderTraversal(rootSingleRecursive));
        assertArrayEquals(new int[]{1}, preorderTraversal(rootSingleIterative));
        assertArrayEquals(new int[]{1}, inorderTraversal(rootSingleIterative));

        // Edge case: Empty tree
        int[] preorderEmpty = {};
        int[] inorderEmpty = {};
        // Verify
        assertNull(builder.buildTreeRecursive(preorderEmpty, inorderEmpty));
        assertNull(builder.buildTreeIterative(preorderEmpty, inorderEmpty));

        // Edge case: Unbalanced tree
        int[] preorderUnbalanced = {1, 2, 3};
        int[] inorderUnbalanced = {3, 2, 1};
        TreeNode rootUnbalancedRecursive = builder.buildTreeRecursive(preorderUnbalanced, inorderUnbalanced);
        TreeNode rootUnbalancedIterative = builder.buildTreeIterative(preorderUnbalanced, inorderUnbalanced);
        // Verify
        assertArrayEquals(new int[]{1, 2, 3}, preorderTraversal(rootUnbalancedRecursive));
        assertArrayEquals(new int[]{3, 2, 1}, inorderTraversal(rootUnbalancedRecursive));
        assertArrayEquals(new int[]{1, 2, 3}, preorderTraversal(rootUnbalancedIterative));
        assertArrayEquals(new int[]{3, 2, 1}, inorderTraversal(rootUnbalancedIterative));

        // Edge case: Full binary tree
        int[] preorderFull = {1, 2, 4, 5, 3, 6, 7};
        int[] inorderFull = {4, 2, 5, 1, 6, 3, 7};
        TreeNode rootFullRecursive = builder.buildTreeRecursive(preorderFull, inorderFull);
        TreeNode rootFullIterative = builder.buildTreeIterative(preorderFull, inorderFull);
        // Verify
        assertArrayEquals(new int[]{1, 2, 4, 5, 3, 6, 7}, preorderTraversal(rootFullRecursive));
        assertArrayEquals(new int[]{4, 2, 5, 1, 6, 3, 7}, inorderTraversal(rootFullRecursive));
        assertArrayEquals(new int[]{1, 2, 4, 5, 3, 6, 7}, preorderTraversal(rootFullIterative));
        assertArrayEquals(new int[]{4, 2, 5, 1, 6, 3, 7}, inorderTraversal(rootFullIterative));
    }

    private int[] preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }

    private int[] inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }
}