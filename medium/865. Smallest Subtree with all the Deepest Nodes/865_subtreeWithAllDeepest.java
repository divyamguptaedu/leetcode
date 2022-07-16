"
Performance:
Runtime: 1 ms, faster than 86.60% of Java online submissions for Smallest Subtree with all the Deepest Nodes.
Memory Usage: 42.2 MB, less than 52.35% of Java online submissions for Smallest Subtree with all the Deepest Nodes.
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
    TreeNode node;
    int maximum = Integer.MIN_VALUE;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        node = new TreeNode();
        helper(root, 0);
        return node;
    }
    
    public int helper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = depth;
        int right = depth;
        if (root.left != null) {
            left = helper(root.left, depth + 1);
        }
        if (root.right != null) {
            right = helper(root.right, depth + 1);
        }
        int result = Math.max(left, right);
        if (result >= maximum && left == right) {
            node = root;
            maximum = result;   
        }
        
        return result;
    }
}