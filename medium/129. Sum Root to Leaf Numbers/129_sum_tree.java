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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, root.val));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> nodePair = stack.pop();
            TreeNode node = nodePair.getKey();
            Integer value = nodePair.getValue();
            if (node.left == null && node.right == null) {
                result += value;
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, value * 10 + node.left.val));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, value * 10 + node.right.val));
            }
        }
        return result;
    }
}