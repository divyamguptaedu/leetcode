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
    List<List<Integer>> result;
    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = traverse(node.left);
        int rightHeight = traverse(node.right);
        int nodeHeight = Math.max(leftHeight, rightHeight) + 1;
        if (result.size() == nodeHeight) {
            result.add(new ArrayList<>());
        }
        result.get(nodeHeight).add(node.val);
        return nodeHeight;
    }
}