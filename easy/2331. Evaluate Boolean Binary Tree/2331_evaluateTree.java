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
    public boolean evaluateTree(TreeNode root) {
        return evaluate(root);
    }

    private boolean evaluate(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            if (node.val == 0) return false;
            if (node.val == 1) return true;
        }
        boolean left = evaluate(node.left);
        boolean right = evaluate(node.right);
        if (node.val == 2) return left || right;
        if (node.val == 3) return left && right;
        return false;
    }
}