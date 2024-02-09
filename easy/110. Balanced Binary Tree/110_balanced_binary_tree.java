/*
Runtime: 1 ms, faster than 95.05% of Java online submissions for Balanced Binary Tree.
Memory Usage: 43.8 MB, less than 67.58% of Java online submissions for Balanced Binary Tree.
*/

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
    
    public boolean result = true;
    
    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }
    
    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        if (Math.abs(leftHeight - rightHeight) > 1){
            this.result = false;
            return 0;
        }
        
        return (Math.max(leftHeight, rightHeight) + 1);
    }
}

//another solution:

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        boolean isLeft = isBalanced(root.left);
        boolean isRight = isBalanced(root.right);
        return isLeft && isRight;
    }
    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        return 1 + Math.max(left, right);
    }

}