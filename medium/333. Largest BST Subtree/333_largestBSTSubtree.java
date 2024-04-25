//Used DFS traversal (post order traversal) and
//saved the isBST value, minimumSeen, maximumSeen, and largestBSTSizeSeen value for every recursion.
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
    public int largestBSTSubtree(TreeNode root) {
        int[] result = helper(root);
        return result[3];
    }

    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] result = new int[4];
        int[] leftResult = helper(root.left);
        int[] rightResult = helper(root.right);
        
        boolean isBST = leftResult[0] == 1 && rightResult[0] == 1 && root.val > leftResult[2] && root.val < rightResult[1]; //BST conditions

        if (isBST) {
            result[0] = 1; // if it's a BST, then 1, otherwise 0.
            result[1] = Math.min(Math.min(leftResult[1], rightResult[1]), root.val); //minimum value seen
            result[2] = Math.max(Math.max(leftResult[2], rightResult[2]), root.val); //maximum value seen
            result[3] = 1 + leftResult[3] + rightResult[3]; //size
        } else {
            result[3] = Math.max(leftResult[3], rightResult[3]);
        }
        return result;
    }
}