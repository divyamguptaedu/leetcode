"""
Performance:
Runtime: 1 ms, faster than 30.05% of Java online submissions for Binary Tree Maximum Path Sum.
Memory Usage: 45.2 MB, less than 8.76% of Java online submissions for Binary Tree Maximum Path Sum.
"""
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
    int answer;
    public int maxPathSum(TreeNode root) {
        answer = 0;
        helper(root);
        return answer;
    }
    
    public int helper(TreeNode root){
        if (root == null) {                      
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int temp = Math.max(root.val, Math.max(left, right) + root.val);  
        int result = Math.max(temp, left + right + root.val);
        answer = Math.max(answer, result);
        return temp;
    }
}



