//In solving the problem of converting a Binary Search Tree (BST) into a Greater Tree, 
//I employed a recursive approach. Starting from the rightmost node, 
//I traversed the BST in reverse order (right subtree, root, left subtree). 
//This allowed me to accumulate the sum of all greater keys encountered so far. 
//For each node, I added this accumulated sum to the node's value, updating the node to reflect its new value. 
//This approach leverages the properties of BSTs, 
//ensuring that each node's new value includes the sum of all greater keys as required.
//Time: n
//Space: height of the tree
class Solution {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}

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
    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        traverse(root);
        return root;
    }

    private TreeNode traverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        traverse(node.right);
        sum += node.val;
        node.val = sum;
        traverse(node.left);
        return node;
    }
}