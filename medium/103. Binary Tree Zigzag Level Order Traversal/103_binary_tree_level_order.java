"""
Performance: 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
Memory Usage: 39.2 MB, less than 35.74% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    List<List<Integer>> result = new ArrayList();
	    helper(result, 0, root);
	    return result;
	}
	// level order traversal;
	private void helper(List<List<Integer>> result, int level, TreeNode cur) {
	    if (cur == null) {
	    	return;
	    }
	    // base case;
	    if (result.size() <= level) {
	        result.add(new ArrayList<Integer>());
	    }
	    // even condition/
	    if (level % 2 == 0) {
	        result.get(level).add(cur.val);
	        // odd condition;
	    }   else {
	        result.get(level).add(0, cur.val);
	    }
	    // recurse;
	    helper(result, level + 1, cur.left);
	    helper(result, level + 1, cur.right);
	}
}