"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
Memory Usage: 38.7 MB, less than 66.90% of Java online submissions for Convert Sorted Array to Binary Search Tree.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        // base case
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode();
        
        // base case
        if (left == right) {
            root.val = nums[left];
            root.left = root.right = null;
            return root;
        }

        // finding a new middle to add
        int mid = left + (right - left)/2;
        root.val = nums[mid];

        // dividing the array and recursing on each part.
        root.left = sortedArrayToBST(nums, left, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, right);
        return root;
    }
}