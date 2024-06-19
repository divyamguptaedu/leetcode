//I solved the problem by implementing an in-order traversal for the binary search tree (BST), 
//which processes nodes in ascending order. I defined a helper function that recursively traversed the left subtree, 
//processed the current node, and then traversed the right subtree. I used a counter to track the number of nodes visited. 
//When the counter equaled k, I recorded the current node as the kth smallest element. 
//The main method called this helper function and returned the value of the kth smallest node.
//Time: n
//Space: h where h is the height of the tree.

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
    // Variable to store the kth smallest node
    TreeNode kthSmallestNode;
    // Counter to track the number of visited nodes
    int visitedCount = 0;

    public int kthSmallest(TreeNode root, int k) {
        findKthSmallest(root, k);
        return kthSmallestNode.val;
    }

    private void findKthSmallest(TreeNode currentNode, int k) {
        if (currentNode == null || kthSmallestNode != null) {
            return;
        }
        // Traverse left subtree
        findKthSmallest(currentNode.left, k);
        visitedCount++;
        // Check if current node is the kth smallest
        if (k == visitedCount) {
            kthSmallestNode = currentNode;
            return;
        }
        // Traverse right subtree
        findKthSmallest(currentNode.right, k);
    }
}