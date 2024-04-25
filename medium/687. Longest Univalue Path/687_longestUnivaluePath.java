//Used simple recursive solution DFS in which the current node's value is compared with the parent, 
//and it it is equal then the max of left and right + 1 is returned.
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
    int result = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root, -1);
        return result;
    }
    int helper(TreeNode currentNode, int parent) {
        if (currentNode == null) {
            return 0;
        }
        int left = helper(currentNode.left, currentNode.val);
        int right = helper(currentNode.right, currentNode.val);
        result = Math.max(result, left + right);

        if (currentNode.val == parent) {
            return Math.max(left, right) + 1;
        } else {
            return 0;
        }
    }
}