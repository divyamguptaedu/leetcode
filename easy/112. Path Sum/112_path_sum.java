//Used a simple recursive approach by subtracting the value of the sum by the value of the node and 
//checking if sum==0 when the recursion hits a leaf node.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        if ((root.left == null) && (root.right == null)) { //leaf node
            return (sum == 0);
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}