"
Performance:
Runtime: 2 ms, faster than 63.77% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
Memory Usage: 46.5 MB, less than 73.78% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
"

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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        helper(original, cloned, target);
        return node;
    }

    TreeNode node = null;
    public void helper(TreeNode original, TreeNode cloned, TreeNode target){
        if (original == null){
            return;
        }
        if (original == target){
            node = cloned;
            return;
        }
        helper(original.left, cloned.left, target);
        helper(original.right, cloned.right, target);
    }
}