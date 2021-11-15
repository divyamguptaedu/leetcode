"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
Memory Usage: 36.6 MB, less than 53.26% of Java online submissions for Sum Root to Leaf Numbers.
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
    public int sumNumbers(TreeNode root) {
       return helper(root, 0); 
    }
    
    private int helper(TreeNode node, int path) {
        if (node == null) {
            return 0;
        }
        path = (path * 10) + node.val;
        
        if (node.left == null && node.right == null) {
            return path;
        }
    
        return helper(node.left, path) + helper(node.right, path);
    }   
}