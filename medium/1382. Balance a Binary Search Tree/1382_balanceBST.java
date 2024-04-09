// Time Complexity = O(n)
// Space Complexity = O(n)

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
        
        int mid = (left + right) / 2;
        TreeNode curr = inorder.get(mid);
        
        curr.left = createBalancedBST(left, mid - 1);
        curr.right = createBalancedBST(mid + 1, right);
        
        return curr;
    }
}