"""
Performance:
Runtime: 1 ms, faster than 57.53% of Java online submissions for Binary Tree Level Order Traversal.
Memory Usage: 39.4 MB, less than 38.12% of Java online submissions for Binary Tree Level Order Traversal.
"""

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
    public List<List<Integer>> levelOrder(TreeNode root) {

       	List<List<Integer>> result = new ArrayList<>();
       	if (root == null) {
       		return result;
       	}
       	List<Integer> level;

            // add first level to a queue;
       	Queue<TreeNode> queue = new ArrayDeque<>();
       	queue.add(root);

            // while queue is not empty, find the next level and add to result;
       	while (!queue.isEmpty()) {
       		int size = queue.size();
       		level = new ArrayList<>();

       		while (size != 0) {
       			TreeNode temp = queue.peek();
       			level.add(temp.val);
       			if (temp.left != null) {
       				queue.add(temp.left);
       			}
       			if (temp.right != null) {
       				queue.add(temp.right);
       			}
       			queue.poll();
       			size--;
       		}
                  
                  // add the new level to the result;
       		result.add(level);
       	}
       	return result;

    }
}