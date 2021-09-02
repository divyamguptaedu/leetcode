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

/*
1. Get the maximum element in the nums array and make a new node with that data.
2. Do the same for left and right. Then recurse.

Note: Helper method needed for recursion.
Note: Another helper method needed to find the maximum.
*/
class Solution {
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }
    
    public TreeNode helper(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int max = maximum(nums, start, end);
        TreeNode root = new TreeNode(nums[max]);
        root.left = helper(nums, start, max);
        root.right = helper(nums, max + 1, end);
        return root;
    }
    
    public int maximum(int[] nums, int start, int end) {
        int maximum = start;
        for (int i = start; i < end; i++) {
            if (nums[maximum] < nums[i]) {
                maximum = i;
            }
        }
        return maximum;
    }
}