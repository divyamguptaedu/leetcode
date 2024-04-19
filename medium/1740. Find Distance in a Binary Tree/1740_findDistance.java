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
//Space: O(1)
class Solution {

    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = LCA(root, p, q);
        return DFS(lca, p, 0) + DFS(lca, q, 0);
    }

    public TreeNode LCA(TreeNode currentNode, int p, int q) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.val == p || currentNode.val == q) {
            return currentNode;
        }
        TreeNode leftTree = LCA(currentNode.left, p, q);
        TreeNode rightTree = LCA(currentNode.right, p, q);
        if (leftTree != null && rightTree != null) {
           return currentNode; 
        }
        if (leftTree == null) {
            return rightTree;
        } else {
            return leftTree;
        }  
    }

    public int DFS(TreeNode node, int target, int length) {
        if (node == null) {
            return 0;
        }
        
        if (node.val == target) {
            return length;
        }

        return Math.max(DFS(node.left, target, length + 1), DFS(node.right, target, length + 1));
    }
}