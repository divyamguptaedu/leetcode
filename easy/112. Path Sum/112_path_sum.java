/*
Runtime: 1 ms, faster than 46.73% of Java online submissions for Path Sum.
Memory Usage: 43.7 MB, less than 48.38% of Java online submissions for Path Sum.
*/

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
    public boolean hasPathSum(TreeNode node, int tar) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null && tar - node.val == 0) {
            return true;
        }
        return hasPathSum(node.left, tar - node.val) || hasPathSum(node.right, tar - node.val);
    }
}