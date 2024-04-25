//Used a simple recursive approach by keeping track of the minimum and 
//maximum possible value for each node and then checking if it lies in between them, inclusive.
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
//Time : O(n)
//Space : O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);  
    }

    public boolean validate(TreeNode root, Integer minimumValue, Integer maximumValue) {
        if (root == null) {
            return true;
        }
        if ((minimumValue != null && root.val <= minimumValue) || (maximumValue != null && root.val >= maximumValue)) {
            return false;
        }

        return validate(root.left, minimumValue, root.val) && validate(root.right, root.val, maximumValue);
    }
}