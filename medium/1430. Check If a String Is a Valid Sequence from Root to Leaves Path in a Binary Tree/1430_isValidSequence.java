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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr, 0);
    }
    
    private boolean isValid(TreeNode node, int[] arr, int index) {
        if (node == null || arr.length == 0) {
            return false;
        }
        if (index >= arr.length || node.val != arr[index]) {
            return false;
        }
        if (node.left == null && node.right == null && index == arr.length - 1) {
            return true;
        }
        return isValid(node.left, arr, index + 1) || isValid(node.right, arr, index + 1);
    }
}