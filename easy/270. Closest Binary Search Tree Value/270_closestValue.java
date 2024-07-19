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
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        int result = root.val;
        while (root != null) {
            if (root.val == target) {
                return root.val;
            }
            if (Math.abs(root.val - target) == Math.abs(result - target)) {
                if (root.val < result) {
                    result = root.val;
                }
            } else if (Math.abs(root.val - target) < Math.abs(result - target)) {
                result = root.val;
            }
            if (root.val > target) {
                root = root.left;
            } else if (root.val < target) {
                root = root.right;
            }
        }
        return result;
    }
}