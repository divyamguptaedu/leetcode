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
//Time: O(n)
//Space: O(n)
class Solution {

    public void flatten(TreeNode root) {
        this.flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode leftSubtree = this.flattenTree(node.left);
        TreeNode rightSubtree = this.flattenTree(node.right);

        if (leftSubtree != null) {
            leftSubtree.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        if (rightSubtree == null) {
            return leftSubtree;
        } else {
            return rightSubtree;
        }
    }
}