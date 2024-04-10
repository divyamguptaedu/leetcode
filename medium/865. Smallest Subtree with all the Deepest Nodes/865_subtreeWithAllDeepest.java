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
    int maxDepth = 0;
    TreeNode smallestSubtree;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        lca(root, 0); //find the lca
        return smallestSubtree;
    }

    public int lca(TreeNode root, int level) {
        if (root == null){
            return level;
        }
        
        int left = lca(root.left, level + 1);
        int right = lca(root.right, level + 1);
        
        if (left == right) {
            maxDepth = Math.max(maxDepth, left);
            if (maxDepth == left) {
                smallestSubtree = root;
            }
        }

        return Math.max(left, right); 
    }
}