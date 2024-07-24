//I recursively traversed the binary tree, maintaining the current maximum and 
//minimum values encountered along the path to the current node. 
//At each node, I updated these values and calculated the maximum difference between
//the current node's value and the maximum and minimum values encountered so far. 
//I returned the maximum of these differences. 
//By exploring all paths from the root to leaves, 
//the algorithm found the maximum difference between a node and its ancestor.

//Time: n
//Space: n
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
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, root.val, root.val);
    }

    public int helper(TreeNode node, int curMax, int curMin) {
        // If we encounter leaves, return the max-min along the path
        if (node == null) {
            return curMax - curMin;
        }
        // Otherwise, update max and min
        // and return the max of left and right subtrees
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        int left = helper(node.left, curMax, curMin);
        int right = helper(node.right, curMax, curMin);
        return Math.max(left, right);
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
    int maxDiff;
    public int maxAncestorDiff(TreeNode root) {
        maxDiff = 0;
        traverse(root, root.val, root.val);
        return maxDiff;
    }

    private void traverse(TreeNode node, int currMax, int currMin) {
        if (node == null) {
            return;
        }
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(currMax - node.val), Math.abs(currMin - node.val)));
        currMax = Math.max(currMax, node.val);
        currMin = Math.min(currMin, node.val);
        traverse(node.left, currMax, currMin);
        traverse(node.right, currMax, currMin);
    }
}