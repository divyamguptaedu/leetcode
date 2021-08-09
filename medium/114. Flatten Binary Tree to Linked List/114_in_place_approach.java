"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
Memory Usage: 38.6 MB, less than 38.61% of Java online submissions for Flatten Binary Tree to Linked List.
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

	TreeNode previous;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.left = null;
		root.right = previous;
		previous = root;

	}

}
