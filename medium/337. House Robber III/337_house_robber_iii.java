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
    public int rob(TreeNode root) {
        return robHelper(root, false);
    }

    // get level order traversal and return maximum of alternate levels' sum;
    public int robHelper(TreeNode root, Boolean isParentRobbed) {
    	if (root == null) {
    		return 0;
    	}
    	if (isParentRobbed) {
    		return robHelper(root.left, false) + robHelper(root.right, false);
    	}

    	return Math.max(robHelper(root.left, false) + robHelper(root.right, false), 
    		robHelper(root.left, true) + robHelper(root.right, true) + root.val);
    	
    }
}