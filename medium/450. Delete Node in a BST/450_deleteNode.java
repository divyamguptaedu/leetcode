"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
Memory Usage: 50.3 MB, less than 8.26% of Java online submissions for Delete Node in a BST.
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right= deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            
            root.val = helper(root.right);
            root.right = deleteNode(root.right , root.val);
        }
        return root;
    }
    
    int helper(TreeNode current){
        while (current.left != null) {
            current = current.left;
        }
        return current.val;
    }
}