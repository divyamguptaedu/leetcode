"""
Performance:
Runtime: 1 ms, faster than 38.37% of Java online submissions for Kth Smallest Element in a BST.
Memory Usage: 39.4 MB, less than 32.83% of Java online submissions for Kth Smallest Element in a BST.
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(list, root);
        // return kth element from the in-order traversal.
        return list.get(k - 1);
    }

    // performing in-order traversal.
    private void inOrderTraverse(List<Integer> list, TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	inOrderTraverse(list, root.left);
    	list.add(root.val);
    	inOrderTraverse(list, root.right);
    }
}