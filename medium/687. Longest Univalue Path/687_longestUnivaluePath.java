"
Performance:
Runtime: 11 ms, faster than 86.69% of Java online submissions for Longest Univalue Path.
Memory Usage: 71.4 MB, less than 95.22% of Java online submissions for Longest Univalue Path.
"

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
    int maximum = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return maximum > 0 ? maximum - 1 : 0;
    }
    
    private int[] helper(TreeNode root, int temp) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, 0};
        }
        int current = root.val;
        int[] left = helper(root.left, current);
        int[] right = helper(root.right, current);
        
        if (left[0] == current && right[0] == current) {
            maximum = Math.max(maximum, left[1] + right[1] + 1); 
        } else if (left[0] == current) {
            maximum = Math.max(maximum, left[1] + 1);
            right[1] = 0;
        } else if (right[0] == current) {
            maximum = Math.max(maximum, right[1] + 1);
            left[1] = 0;
        } else {
            left[1] = 0;
            right[1] = 0;
        }
        
        int result = Math.max(left[1], right[1]) + 1;
        
        return new int[]{current, result};
    }
}