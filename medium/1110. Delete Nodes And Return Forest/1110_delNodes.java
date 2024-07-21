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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Set<Integer> toDelete = new HashSet<>();
        for (int val : to_delete) {
            toDelete.add(val);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                if (toDelete.contains(node.left.val)) {
                    node.left = null;
                }
            }
            if (node.right != null) {
                queue.add(node.right);
                if (toDelete.contains(node.right.val)) {
                    node.right = null;
                }
            }
            if (toDelete.contains(node.val)) {
                if (node.left != null) {
                    result.add(node.left);
                }
                if (node.right != null) {
                    result.add(node.right);
                }
            }
        }
        if (!toDelete.contains(root.val)) {
            result.add(root);
        }
        return result;
    }
}