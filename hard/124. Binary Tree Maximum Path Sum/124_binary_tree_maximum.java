//Used a recursive approach with simply keeping track of maxSum till now. 
//maxSum is calculated by adding the leftSum, rightSum, and the value of the node.
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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = helper(root.left);
        leftSum = leftSum > 0 ? leftSum : 0;
        int rightSum = helper(root.right);
        rightSum = rightSum > 0 ? rightSum : 0;

        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        return Math.max(leftSum + root.val, rightSum + root.val);
    }
}


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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        traverse(root);
        return maxSum;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(traverse(node.left), 0);
        int right = Math.max(traverse(node.right), 0);
        maxSum = Math.max(maxSum, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}