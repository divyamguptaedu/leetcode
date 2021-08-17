"""
Performance:
Runtime: 2 ms, faster than 96.95% of Java online submissions for Count Good Nodes in Binary Tree.
Memory Usage: 47.6 MB, less than 85.31% of Java online submissions for Count Good Nodes in Binary Tree.
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

    int good;

    public int goodNodes(TreeNode root) {
        good = 0;
        helper(root, Integer.MIN_VALUE);
        return good;
    }

    void helper(TreeNode root, int max){
        if (root == null) {
        	return;
        }
        if (root.val >= max) {
        	good++;
        }
        max = Math.max(max, root.val);
        helper(root.left, max);
        helper(root.right, max);
    }
}

