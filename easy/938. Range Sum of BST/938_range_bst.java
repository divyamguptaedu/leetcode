"
Performance:
Runtime: 1 ms, faster than 51.35% of Java online submissions for Range Sum of BST.
Memory Usage: 46.9 MB, less than 93.11% of Java online submissions for Range Sum of BST.
"

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
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        result = 0;
        helper(root, low, high);
        return result;
    }
    
    // inorder traversal
    private void helper(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        helper(root.left, low, high);
        // add to result only if conditions meet;
        if (root.val >= low && root.val <= high) {
            result += root.val;
        }
        helper(root.right, low, high);
    }
}