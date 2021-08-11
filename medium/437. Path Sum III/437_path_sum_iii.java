"""
Performance:
Runtime: 20 ms, faster than 38.14% of Java online submissions for Path Sum III.
Memory Usage: 38.8 MB, less than 57.18% of Java online submissions for Path Sum III.
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

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
        	return 0;
        }
        int count = helper(root, targetSum);

        // increment count with root's left and right path sum;
        return count + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

    }

    private int helper(TreeNode root, int targetSum) {

    	if (root == null) {
    		return 0;
    	}
    	int count = 0;

        // if targetSum is achieved, increment count;
    	if (root.val == targetSum) {
    		count++;
    	}

        // increment count with left and right root with new target sum;
    	return count + helper(root.left, targetSum - root.val) + helper(root.right, targetSum - root.val);

    }

}