// Time Complexity: O(n)
// Space Complexity: O(1)

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
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = lowestCommonAncestor(root, p, q); //calculate the lca
        int h1 = calculateDepth(lca, p, 0); //edges between lca and p
        int h2 = calculateDepth(lca, q, 0); //edges between lca and q
        return h1 + h2;
    }

    private TreeNode lowestCommonAncestor(TreeNode node, int p, int q) {
        if (node == null || node.val == p || node.val == q) {
            return node;
        }
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }

    private int calculateDepth(TreeNode root, int input, int index) {
        if (root == null) {
            return 0;
        }
        if (root.val == input) {
            return index;
        }
        int d = calculateDepth(root.left, input, index + 1);
        if (d != 0) {
            return d;
        } else {
            d = calculateDepth(root.right, input, index + 1);
            return d;
        }
    }
}