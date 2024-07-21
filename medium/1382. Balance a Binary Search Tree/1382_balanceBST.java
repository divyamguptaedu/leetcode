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
    List<TreeNode> inorder;
    
    public TreeNode balanceBST(TreeNode root) {
        inorder = new ArrayList<>();
        inOrder(root);
        return createBalancedBST(0, inorder.size() - 1);
    }
    
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inorder.add(node);
        inOrder(node.right);
    }
    
    public TreeNode createBalancedBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int middleIndexToBreakLeftRight = (left + right) / 2;
        TreeNode root = inorder.get(middleIndexToBreakLeftRight);
        root.left = createBalancedBST(left, middleIndexToBreakLeftRight - 1);
        root.right = createBalancedBST(middleIndexToBreakLeftRight + 1, right);
        return root;
    }
}