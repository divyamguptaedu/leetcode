/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time: O(n)
//Space: O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int valueOfP = p.val;
        int valueOfQ = q.val;
        TreeNode node = root;
        while (node != null) {
            int valueOfNode = node.val;
            if (valueOfP > valueOfNode && valueOfQ > valueOfNode) {
                node = node.right;
            } else if (valueOfP < valueOfNode && valueOfQ < valueOfNode) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}