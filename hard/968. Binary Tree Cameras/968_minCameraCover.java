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

 //0: need camera
 //1: is camera
 //2: has monitoring
class Solution {
    int count;
    public int minCameraCover(TreeNode root) {
        count = 0;
        if (root == null) {
            return count;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (traverse(root) == 0) {
            count++;
        }
        return count;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 2;
        }
        int left = traverse(node.left);
        int right = traverse(node.right);
        if (left == 0 || right == 0) {
            count++;
            return 1;
        } else if (left == 1 || right == 1) {
            return 2;
        } else {
            return 0;
        }
    }
}