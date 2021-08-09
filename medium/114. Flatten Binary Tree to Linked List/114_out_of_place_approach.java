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

    public void flatten(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        preorder(root, preorderList);
        TreeNode current = new TreeNode(preorderList.get(0));
        root = current;
        for (int i = 1; i < preorderList.size(); i++) {
        	current.right = new TreeNode(preorderList.get(i));
        	current = current.right;
        }
    }

    private void preorder(TreeNode root, List<Integer> result) {
    	if (root != null) {
    		result.add(root.val);
    		preorder(root.left, result);
    		preorder(root.right, result);
    	}
    }
}