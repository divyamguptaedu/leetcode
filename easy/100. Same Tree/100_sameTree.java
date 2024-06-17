//To determine if two binary trees are the same, I used a recursive approach. 
//I compared the root nodes of both trees and then recursively compared their left and right subtrees. 
//If both nodes were null, the trees were considered identical. If one node was null and the other wasn't, 
//or if their values didn't match, the trees were not identical. 
//This approach ensured that both the structure and node values of the trees were checked for equality.

//Time: n
//Space: n
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null)
            return true;
        // one of p and q is null
        if (q == null || p == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}