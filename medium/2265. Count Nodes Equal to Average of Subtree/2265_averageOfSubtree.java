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
    class Pair {
        int sum;
        int count;
        public Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    int result;

    public int averageOfSubtree(TreeNode root) {
        result = 0;
        helper(root);
        return result;
    }

    public Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        int sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;

        if (sum / count == root.val) {
            result++;
        }

        return new Pair(sum, count);
    }
}