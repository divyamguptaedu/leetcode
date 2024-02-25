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
    int[] left = new int[1001];
    int[] right = new int[1001];

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root);
        return runLogic(root);
    }

    TreeNode runLogic(TreeNode root){
        if (left[root.val] == right[root.val]) {
            return root;
        } else if (left[root.val] > right[root.val]) {
            return runLogic(root.left);
        } else {
            return runLogic(root.right);
        }
    }

    int helper(TreeNode root){
        if (root == null) {
            return 0;
        }
        left[root.val] = helper(root.left);
        right[root.val] = helper(root.right);
        return Math.max(left[root.val], right[root.val]) + 1;
    }
}