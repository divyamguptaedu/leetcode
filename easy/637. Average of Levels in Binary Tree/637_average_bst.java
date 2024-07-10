//Used a simple interative BFS approach, using the length of the queue at each level 
//and calculating the average at each level by keeping track of the sum at each level.

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
//Time: O(n)
//Space: O(m) m is the maximum nodes in a level
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }
}