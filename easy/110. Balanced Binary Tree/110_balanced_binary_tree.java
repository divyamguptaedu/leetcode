// Time Complexity: O(nlogn)
// Space Complexity: O(n)

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
    public boolean isBalanced(TreeNode root) {
        return heightOfNode(root) != -1;
    }
    private int heightOfNode(TreeNode root) {
        if (root == null) {
            return 0; //empty tree
        }
        int leftHeight = heightOfNode(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = heightOfNode(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(heightOfNode(root.left), heightOfNode(root.right)) + 1;
    }
}