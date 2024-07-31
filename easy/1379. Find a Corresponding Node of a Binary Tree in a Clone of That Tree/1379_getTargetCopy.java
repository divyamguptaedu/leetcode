/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode result;
    TreeNode target;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        traverse(original, cloned);
        return result;
    }

    private void traverse(TreeNode original, TreeNode cloned) {
        if (original == null) {
            return;
        }
        if (original == target) {
            result = cloned;
        }
        traverse(original.left, cloned.left);
        traverse(original.right, cloned.right);
    }
}