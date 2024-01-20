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
    public int diameterOfBinaryTree(TreeNode root) {
        int dm[] = new int[1];
        helper(root, dm);
        return dm[0];
    }

    public int helper(TreeNode root, int dm[]){
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, dm);
        int right = helper(root.right, dm);
        dm[0] = Math.max(dm[0], left + right);
        return Math.max(left, right) + 1;
    }
}