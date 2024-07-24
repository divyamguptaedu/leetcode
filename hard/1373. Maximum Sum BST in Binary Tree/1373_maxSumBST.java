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

class NodeValue {
    int minValue;
    int maxValue;
    int maxSum;
    NodeValue(int minValue, int maxValue, int maxSum) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxSum = maxSum;
    }
}

class Solution {
    int result;
    public int maxSumBST(TreeNode root) {
        result = 0;
        traverse(root);
        return result;
    }

    private NodeValue traverse(TreeNode node) {
        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = traverse(node.left);
        NodeValue right = traverse(node.right);
        if (left.maxValue < node.val && right.minValue > node.val) {
            int sum = left.maxSum + right.maxSum + node.val;
            result = Math.max(result, sum);
            return new NodeValue(Math.min(node.val, left.minValue), Math.max(node.val, right.maxValue), sum);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSum, right.maxSum));
    } 
}