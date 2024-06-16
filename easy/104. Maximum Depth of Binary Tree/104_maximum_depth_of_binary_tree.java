//In solving the problem of finding the maximum depth of a binary tree, 
//I opted for a recursive approach. Starting with the base case, if the root is null, 
//I returned 0 since there are no nodes. For non-null nodes, 
//I recursively calculated the maximum depth of the left and right subtrees using 
//maxDepth(root.left) and maxDepth(root.right), respectively.
//The depth of the current node is then determined as 1 plus the maximum depth between its left and 
//right subtrees (1 + Math.max(...)), ensuring each recursive call contributes to calculating 
//the overall depth from the root to the deepest leaf.

//Time: n
//Space: h where h is the height of the binary tree.

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
           return  0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}