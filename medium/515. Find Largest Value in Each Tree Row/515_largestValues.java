"
Performance:
Runtime: 2 ms, faster than 82.34% of Java online submissions for Find Largest Value in Each Tree Row.
Memory Usage: 42.2 MB, less than 98.82% of Java online submissions for Find Largest Value in Each Tree Row.
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
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        levelOrder(root, queue);
        return result;
    }
    public void levelOrder(TreeNode root, Queue<TreeNode> queue) {
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maximum = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                maximum = Math.max(maximum, queue.remove().val);
            }
            result.add(maximum);
        }
        
    }
}