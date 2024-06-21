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

/*
First Call:
build(preorder, inorder, Integer.MIN_VALUE)
preorder[0] = 3, create TreeNode(3), p = 1
Build left subtree with build(preorder, inorder, 3)

Second Call:
build(preorder, inorder, 3)
preorder[1] = 9, create TreeNode(9), p = 2
Build left subtree with build(preorder, inorder, 9)
inorder[0] = 9 matches stop, i = 1, return null
Build right subtree with build(preorder, inorder, 3)
inorder[1] = 3 matches stop, i = 2, return null

Back to First Call:
Set left child of TreeNode(3) to TreeNode(9)
Build right subtree with build(preorder, inorder, Integer.MIN_VALUE)

Third Call:
build(preorder, inorder, Integer.MIN_VALUE)
preorder[2] = 20, create TreeNode(20), p = 3
Build left subtree with build(preorder, inorder, 20)
preorder[3] = 15, create TreeNode(15), p = 4
Build left subtree with build(preorder, inorder, 15)
inorder[2] = 15 matches stop, i = 3, return null
Build right subtree with build(preorder, inorder, 20)
inorder[3] = 20 matches stop, i = 4, return null

Back to Third Call:
Set left child of TreeNode(20) to TreeNode(15)
Build right subtree with build(preorder, inorder, Integer.MIN_VALUE)
preorder[4] = 7, create TreeNode(7), p = 5
Build left subtree with build(preorder, inorder, 7)
inorder[4] = 7 matches stop, i = 5, return null
Build right subtree with build(preorder, inorder, Integer.MIN_VALUE)
i = 5 exceeds array length, return null

Final Assembly:
Set right child of TreeNode(20) to TreeNode(7)

Output: [3, 9, 20, null, null, 15, 7]
*/
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