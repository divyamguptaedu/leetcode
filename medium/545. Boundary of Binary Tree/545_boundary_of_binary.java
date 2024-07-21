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
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //add the root val to the result
        result.add(root.val);

        //add left boundary nodes
        TreeNode leftSubtree = root.left;
        while (leftSubtree != null) {
            if (leftSubtree.left != null || leftSubtree.right != null) {
                result.add(leftSubtree.val);
            }
            if (leftSubtree.left != null) {
                leftSubtree = leftSubtree.left;
            } else {
                leftSubtree = leftSubtree.right;
            }
        }

        //add leaf nodes
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null && node != root) {
                result.add(node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        //add right boundary nodes
        stack = new Stack<>();
        TreeNode rightSubtree = root.right;
        while (rightSubtree != null) {
            if (rightSubtree.left != null || rightSubtree.right != null) {
                stack.add(rightSubtree);
            }
            if (rightSubtree.right != null) {
                rightSubtree = rightSubtree.right;
            } else {
                rightSubtree = rightSubtree.left;
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }

        return result;
    }
}