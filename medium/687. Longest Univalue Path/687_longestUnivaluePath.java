//Used simple recursive solution DFS in which the current node's value is compared with the parent, 
//and it it is equal then the max of left and right + 1 is returned.
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
    int result = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root, -1);
        return result;
    }
    int helper(TreeNode currentNode, int parent) {
        if (currentNode == null) {
            return 0;
        }
        int left = helper(currentNode.left, currentNode.val);
        int right = helper(currentNode.right, currentNode.val);
        result = Math.max(result, left + right);

        if (currentNode.val == parent) {
            return Math.max(left, right) + 1;
        } else {
            return 0;
        }
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
    int maxPath;
    public int longestUnivaluePath(TreeNode root) {
        maxPath = 0;
        traverse(root);
        return maxPath;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left);
        int right = traverse(node.right);
        int pathLength = 0;
        if (node.left != null && node.right != null && node.val == node.left.val && node.val == node.right.val) {
            maxPath = Math.max(maxPath, left + right + 2);
            return Math.max(left, right) + 1;
        } else if (node.left != null && node.val == node.left.val) {
            maxPath = Math.max(maxPath, left + 1);
            return left + 1;
        } else if (node.right != null && node.val == node.right.val) {
            maxPath = Math.max(maxPath, right + 1);
            return right + 1;
        } else {
            return 0;
        }
    }
}