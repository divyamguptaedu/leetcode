/**
Runtime: 1 ms, faster than 95.05% of Java online submissions for Minimum Depth of Binary Tree.
Memory Usage: 43.8 MB, less than 67.58% of Java online submissions for Minimum Depth of Binary Tree.
**/

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
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftNode = minDepth(root.leftNode);
        int rightNode = minDepth(root.rightNode);
        if (leftNode == 0 || rightNode == 0) {
			return 1 + leftNode + rightNode;
		}
        return Math.min(leftNode, rightNode) + 1;
    }
}