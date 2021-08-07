"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Binary Trees.
Memory Usage: 38.9 MB, less than 87.76% of Java online submissions for Merge Two Binary Trees.
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // base case when there is a null on both the trees.
        if (root1 == null && root2 == null) {
            return null;
        } 
        // base case when root1 is null.
        if (root1 == null) {
            return root2;
        }
        // base case when root2 is null.
        if (root2 == null) {
            return root1;
        }

        // update root1 by adding values.
        root1.val = root1.val + root2.val;

        // perform recursion on left root1 node and right root1 node.
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}