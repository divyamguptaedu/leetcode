"""
Performance:
Runtime: 3 ms, faster than 64.66% of Java online submissions for Recover Binary Search Tree.
Memory Usage: 47.7 MB, less than 22.37% of Java online submissions for Recover Binary Search Tree.
"""

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
    
    TreeNode previous = null;
    TreeNode first = null;
    TreeNode second = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder (TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (previous != null && root.val < previous.val) { 
            if (first == null) {
                first = previous;
            }
            second = root;
        }
        previous = root;
        inorder(root.right);
    }
}