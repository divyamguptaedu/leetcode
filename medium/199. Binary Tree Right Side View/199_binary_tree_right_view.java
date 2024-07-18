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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeNode prev = root;
        TreeNode curr = root;
        while (!queue.isEmpty()) {
            prev = curr;
            curr = queue.poll();
            while (curr != null) {
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                prev = curr;
                curr = queue.poll();
            }
            result.add(prev.val);
            if (!queue.isEmpty()) {
                queue.add(null);
            }
        }
        return result;
    }
}