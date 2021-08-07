"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
Memory Usage: 38.9 MB, less than 67.53% of Java online submissions for Diameter of Binary Tree.
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
    int depth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return depth;
    }
    
    private int diameterOfBinaryTreeHelper(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        
        // go down on both the sides
        int left = diameterOfBinaryTreeHelper(root.left);
        int right = diameterOfBinaryTreeHelper(root.right);

        // calculate the maximum depth from one node.
        int tempDepth = Math.max(left, right) + 1;

        // update the total maximum depth.
        depth = Math.max(left + right, depth);
        return tempDepth;
    }
}








