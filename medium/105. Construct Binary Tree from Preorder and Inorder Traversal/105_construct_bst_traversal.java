"""
Performance:
Runtime: 1 ms, faster than 98.78% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
Memory Usage: 39.3 MB, less than 30.75% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
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

	int index;
	HashMap<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        indexMap = new HashMap<>();

        // add all inorder indexes in the map;
        for (int i = 0; i < inorder.length; i++) {
        	indexMap.put(inorder[i], i);
        }

	    int left = 0;
	    int right = preorder.length - 1;

	    return helper(preorder, left, right);
	}

	private TreeNode helper(int[] preorder, int left, int right) {
		if (left > right) {
			return null;
		}
		// form a root and set lefts and right according to the preorder;
		int tempVal = preorder[index++];
		TreeNode root = new TreeNode(tempVal);
		root.left = helper(preorder, left, indexMap.get(tempVal) - 1);
		root.right = helper(preorder, indexMap.get(tempVal) + 1, right);
		return root;
	}
}