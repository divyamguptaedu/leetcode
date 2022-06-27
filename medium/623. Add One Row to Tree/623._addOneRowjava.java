"""
Performance:
Runtime: 1 ms, faster than 82.40% of Java online submissions for Add One Row to Tree.
Memory Usage: 45.5 MB, less than 43.69% of Java online submissions for Add One Row to Tree.
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        helper(root, 1, val, depth);
        return root;
    }
    
    public void helper(TreeNode node, int depth, int value, int target) {
        if (node == null) {
            return;
        }
        if (depth + 1 == target) {
                node.left = new TreeNode(value, node.left, null);
                node.right = new TreeNode(value, null, node.right);
        } else {
            helper(node.left, depth + 1, value, target);
            helper(node.right, depth + 1, value, target);
        }
    }
}