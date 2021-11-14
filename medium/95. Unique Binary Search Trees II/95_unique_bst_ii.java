"""
Performance:
Runtime: 2 ms, faster than 35.97% of Java online submissions for Unique Binary Search Trees II.
Memory Usage: 43.6 MB, less than 5.90% of Java online submissions for Unique Binary Search Trees II.
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
    public List<TreeNode> generateTrees(int n) {
       return helper(1, n);
    }
    
    
    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> node = new ArrayList();
        if (left > right) {
            node.add(null);
            return node;
        }
        for (int value = left; value <= right; value++) {
            List<TreeNode> leftBST = helper(left, value - 1);
            List<TreeNode> rightBST = helper(value + 1, right);
            for (TreeNode rightNode : rightBST) {
                for (TreeNode leftNode : leftBST) {
                    TreeNode root = new TreeNode(value);
                    root.left = leftNode;
                    root.right = rightNode;
                    node.add(root);
                }
            }
        }
        return node;
    }
}