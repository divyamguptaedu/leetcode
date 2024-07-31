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
    List<Integer> result;
    public List<Integer> getLonelyNodes(TreeNode root) {
        this.result = new ArrayList<>();
        traverse(root);
        return result;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right == null) result.add(node.left.val);
        if (node.right != null && node.left == null) result.add(node.right.val);
        if (node.left != null) traverse(node.left);
        if (node.right != null) traverse(node.right);
    }
}