/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
//I approached the problem of constructing a binary tree from its preorder and inorder 
//traversals using a recursive approach. Initially, I used indices i and p to track positions 
//in the inorder and preorder arrays, respectively. Starting with the entire range of values, 
//I recursively built nodes: for each node, I created it from preorder[p], moved p forward, 
//and recursively built its left and right subtrees using boundaries defined by stop values. 
//If inorder[i] matches stop, it means the subtree is fully constructed. 
//This method efficiently constructs the binary tree by leveraging the properties of preorder 
//and inorder traversals.

//Time: n
//Space: n

class Solution {
    int i = 0;
    int p = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    public TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length)
            return null;
        if (inorder[i] == stop) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }
}