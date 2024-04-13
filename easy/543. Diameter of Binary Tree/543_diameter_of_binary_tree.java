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
 //Space: O(n) //recursion stack
class Solution {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
    private int dfs(TreeNode node){
        if (node == null) {
            return 0;
        }
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        //update the diameter
        diameter = Math.max(diameter, leftPath + rightPath); //if the right+left height is > than currDiameter, then update it.

        return Math.max(leftPath, rightPath) + 1; //actual logic, for every node, get the height of the left node, then height of the right node, add one to find the height of the currNode.
    }
}