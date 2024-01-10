"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
Memory Usage: 38.5 MB, less than 66.89% of Java online submissions for Validate Binary Search Tree.
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

    public boolean isValidBST(TreeNode root) {
        boolean result = helper(root, null, null);
        return result;
    }

    public boolean helper(TreeNode root, TreeNode minimum, TreeNode maximum) {
        if (root == null) {
            return true;
        }
        if (minimum != null && root.val <= minimum.val) {
            return false;
        }
        if (maximum != null && root.val >= maximum.val) {
            return false;
        }
        return helper(root.left, minimum, root) && helper(root.right, root, maximum);
    }
}

//another solution

class Solution {
    public boolean isValidBST(TreeNode root) {
      return solve(root, null, null);  
    }
    public boolean solve(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return solve(root.left, min, root.val) && solve(root.right, root.val, max);
    }
}
