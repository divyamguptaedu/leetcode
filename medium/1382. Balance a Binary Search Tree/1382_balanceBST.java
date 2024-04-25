//Did an inorder traversal to get the nodes in sorted order. Then just created a BST using the middle value as the root.
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

// Time Complexity = O(n)
// Space Complexity = O(n)

class Solution {
    List<TreeNode> inorder = new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
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
        int middleValueToBreakLeftRight = (left + right) / 2;
        TreeNode currentNode = inorder.get(middleValueToBreakLeftRight);
        currentNode.left = createBalancedBST(left, middleValueToBreakLeftRight - 1);
        currentNode.right = createBalancedBST(middleValueToBreakLeftRight + 1, right);
        return currentNode;
    }
}