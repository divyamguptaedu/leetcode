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
    int prev = Integer.MAX_VALUE;
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper_inorder(root);
        return result;
    }

    public void helper_inorder(TreeNode root) {
        if (root.left != null) {
            helper_inorder(root.left);
        }

        result = Math.min(result, Math.abs(root.val - prev));
        prev = root.val;

        if (root.right != null) {
            helper_inorder(root.right);
        }
    }
}