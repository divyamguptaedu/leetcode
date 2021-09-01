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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new LinkedList<Integer>();
        helper(root, target, k, result);
        return result;
    }
    private void helper(TreeNode root, double target, int k, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left,target,k,result);
        if (result.size() < k) {
            result.add(root.val);
        } else {
            if (Math.abs(result.get(0) - target) > Math.abs(root.val - target)) {
                result.remove(0);
                result.add(root.val);
            } else {
                return;
            }
        }
        helper(root.right,target,k,result);
    }
}