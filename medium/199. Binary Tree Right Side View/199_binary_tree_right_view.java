"""
Performance:
Runtime: 1 ms, faster than 75.58% of Java online submissions for Binary Tree Right Side View.
Memory Usage: 37.8 MB, less than 35.75% of Java online submissions for Binary Tree Right Side View.
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
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) {
        	return result;
        }

        queue.add(root);

        // add the last element of the level order traversal.
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 1; i <= size; i++) {
        		TreeNode node = queue.poll();
        		if (node.left != null) {
        			queue.add(node.left);
        		}
        		if (node.right != null) {
        			queue.add(node.right);
        		}
        		if (i == size) {
        			result.add(node.val);
        		}
        	}
        }
        return result;

    }
}