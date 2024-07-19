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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> ancestors = new HashMap<>();
        stack.push(root);
        ancestors.put(root, null);

        while (!ancestors.containsKey(p) || !ancestors.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                ancestors.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                ancestors.put(node.right, node);
                stack.push(node.right);
            }
        }
        HashSet<TreeNode> parents = new HashSet<>();
        
        while (p != null) {
            parents.add(p);
            p = ancestors.get(p);
        }

        while (!parents.contains(q)) {
            q = ancestors.get(q);
        }
        return q;
    }
}