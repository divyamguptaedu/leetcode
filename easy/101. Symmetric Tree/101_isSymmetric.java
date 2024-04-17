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
//Time : O(n)
//Space : O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    public boolean helper(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }
        return (leftTree.val == rightTree.val) && helper(leftTree.right, rightTree.left) && helper(leftTree.left, rightTree.right);
    }
}