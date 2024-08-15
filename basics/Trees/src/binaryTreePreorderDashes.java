//We run a preorder depth-first search (DFS) on the root of a binary tree.
//At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.
//If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.
//If a node has only one child, that child is guaranteed to be the left child.
//Given the output traversal of this traversal, recover the tree and return its root.
import java.util.*;

class RecoverTreeFromPreorderTraversal {

    public TreeNode recoverFromPreorderRecursive(String traversal) {
        // Initialize the recursive helper with depth 0 and an index tracker.
        return recoverRecursiveHelper(traversal, 0, new int[]{0});
    }

    private TreeNode recoverRecursiveHelper(String traversal, int depth, int[] index) {
        // Count the number of dashes indicating the current depth.
        int numDashes = 0;
        while (index[0] + numDashes < traversal.length() && traversal.charAt(index[0] + numDashes) == '-') {
            numDashes++;
        }

        // If the number of dashes doesn't match the current depth, return null (base case).
        if (numDashes != depth) {
            return null;
        }

        // Move the index past the dashes.
        index[0] += numDashes;

        // Read the node value.
        int val = 0;
        while (index[0] < traversal.length() && Character.isDigit(traversal.charAt(index[0]))) {
            val = val * 10 + (traversal.charAt(index[0]++) - '0');
        }

        // Create a new TreeNode with the read value.
        TreeNode node = new TreeNode(val);

        // Recursively construct the left and right subtrees.
        node.left = recoverRecursiveHelper(traversal, depth + 1, index);
        node.right = recoverRecursiveHelper(traversal, depth + 1, index);

        return node;
    }

    public TreeNode recoverFromPreorderIterative(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;

        while (i < traversal.length()) {
            // Count the number of dashes indicating the depth of the current node.
            int depth = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Read the node value.
            int val = 0;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i++) - '0');
            }

            // Create a new TreeNode with the read value.
            TreeNode node = new TreeNode(val);

            // Pop nodes from the stack until the stack size matches the current depth.
            while (stack.size() > depth) {
                stack.pop();
            }

            // Attach the new node as a left or right child of the node on the top of the stack.
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            // Push the new node onto the stack.
            stack.push(node);
        }

        // The root of the tree is the only remaining node in the stack.
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}