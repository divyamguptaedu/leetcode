//Used a simple recursive approach by keeping track of the previous node value 
//and finding the difference from the current node value.
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
//Time: O(n)
//Space: O(n)
class Solution {
    int previousNodeValue = Integer.MAX_VALUE;
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root) {
        if (root.left != null) {
            inorder(root.left);
        }

        result = Math.min(result, Math.abs(root.val - previousNodeValue));
        previousNodeValue = root.val;

        if (root.right != null) {
            inorder(root.right);
        }
    }
}