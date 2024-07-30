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
    List<Integer> allSums;
    public int maxProduct(TreeNode root) {
        allSums = new ArrayList<>();
        long totalSum = calculateSum(root);
        long best = 0;
        for (int i : allSums) {
            best = Math.max(best, i * (totalSum - i));
        }
        return (int)(best % 1000000007);
    }

    private int calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = calculateSum(node.left);
        int right = calculateSum(node.right);
        int nodeValue = node.val;
        int sum = left + right + nodeValue;
        allSums.add(sum);
        return sum;
    }
}