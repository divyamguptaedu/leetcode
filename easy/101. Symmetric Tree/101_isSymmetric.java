//Used a simple recursive approach by checking if the two nodes at mirroring positions have equal value. 
//The two nodes considered are derived by taking the 
//leftTree.left with rightTree.right and leftTree.right with rightTree.left.
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