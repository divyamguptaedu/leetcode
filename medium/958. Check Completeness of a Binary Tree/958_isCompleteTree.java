"
Performance:
Runtime: 2 ms, faster than 95.12% of Java online submissions for Check Completeness of a Binary Tree.
Memory Usage: 42.3 MB, less than 73.74% of Java online submissions for Check Completeness of a Binary Tree.
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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean check = false;
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.remove();
                if (temp.left != null) {
                    if (check) {
                        return false;
                    }
                    queue.add(temp.left);
                } else {
                    check = true;
                }
                if (temp.right != null) {
                    if (check) {
                        return false;
                    }
                    queue.add(temp.right);
                } else {
                    check = true;
                }
            }
        }
        return true;
    }
}