/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Time: O(n)
//Space: O(n)
class Solution {
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return lca;
    }
    public int recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return 0;
        }
        int left = this.recurseTree(currentNode.left, p, q);
        int right = this.recurseTree(currentNode.right, p, q);
        int mid;
        if (currentNode == p || currentNode == q) {
            mid = 1;
        } else {
            mid = 0;
        }

        if (mid + left + right >= 2) { //If we have two 1s in the three variables, then we found the lca.
            lca = currentNode;
        }

        if (mid + left + right > 0) { // Return 1 if any one of the three values is 1. 
            return 1;
        } else {
            return 0;
        }
    }
}