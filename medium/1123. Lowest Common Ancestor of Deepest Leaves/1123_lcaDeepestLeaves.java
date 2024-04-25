//Simply found the nodes with maxDepth and same LCA. 
//Used recursion DFS, increased level at every left and right call. 
//Kept track of the maxDepth. 
//Changed the assignment of the smallestSubtree whenever left == right and greater than currentMaxDepth.
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
    int maxDepth = 0;
    TreeNode smallestSubtree;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        lca(root, 0); //find the lca
        return smallestSubtree;
    }

    public int lca (TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        
        int left = lca(node.left, level + 1);
        int right = lca(node.right, level + 1);
        
        if (left == right && left >= maxDepth) {
            maxDepth = left;
            smallestSubtree = node;
        }

        return Math.max(left, right); 
    }
}