//Used an iterative approach in which I took advantage of the BST properties. 
//If the value of p and q both is less than the node's value, then set the node to its left, 
//if greater than node, then set it to right, is neither, 
//then return that node because that would mean that the p and q are on the different sides, 
//so we can just return the root.
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