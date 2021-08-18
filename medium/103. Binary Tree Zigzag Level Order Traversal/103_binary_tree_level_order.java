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
	private void helper(List<List<Integer>> result, int level, TreeNode cur) {
	    if (cur == null) {
	    	return;
	    }
	    if (result.size() <= level) {
	        result.add(new ArrayList<Integer>());
	    }
	    if (level % 2 == 0) {
	        result.get(level).add(cur.val);
	    }   else {
	        result.get(level).add(0, cur.val);
	    }
	    helper(result, level + 1, cur.left);
	    helper(result, level + 1, cur.right);
	}
}