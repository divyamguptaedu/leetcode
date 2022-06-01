/*
Runtime: 1 ms, faster than 57.74% of Java online submissions for Cousins in Binary Tree.
Memory Usage: 42.4 MB, less than 15.21% of Java online submissions for Cousins in Binary Tree.
*/

/*
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
    public boolean isCousins(TreeNode root, int A, int B) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            boolean aSameLevel = false;
            boolean bSameLevel = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.val == A)
                    aSameLevel = true;
                if (current.val == B)
                    bSameLevel = true;
                if (current.left != null && current.right != null) {
                    if (current.left.val == A && current.right.val == B) {
                        return false;
                    }
                    if (current.left.val == B && current.right.val == A) {
                        return false;
                    }
                }
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            if (aSameLevel && bSameLevel)
                return true;
             else if (aSameLevel || bSameLevel)
                 return false;
        }
        return false;
    }
}