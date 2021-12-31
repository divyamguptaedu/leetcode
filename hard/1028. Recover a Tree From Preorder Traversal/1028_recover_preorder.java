"
Performance:
Runtime: 5 ms, faster than 44.16% of Java online submissions for Recover a Tree From Preorder Traversal.
Memory Usage: 43.7 MB, less than 8.83% of Java online submissions for Recover a Tree From Preorder Traversal.
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
    
	int index = 0;
    
	public TreeNode recoverFromPreorder(String traversal) {
        if (traversal.isEmpty()) {
            return null;
        }
		return preorder(traversal, 0);
	}

	public TreeNode preorder(String traversal, int depth){
		if (index == traversal.length() || !helper(traversal, depth)) 
            return null;
        
        TreeNode node = new TreeNode(getNodeValue(traversal, depth));
		node.left = preorder(traversal, depth + 1);
		node.right = preorder(traversal, depth + 1);
		return node;
	}
    
        
	private boolean helper(String traversal, int depth){
		int level = 0;
        int i = index; 
        while (i < traversal.length() && traversal.charAt(i++) == '-') {
            level++;
        }
		return level == depth;    
	}

	private int getNodeValue(String traversal, int depth) {
		int i = index + depth;
        while (i < traversal.length() && traversal.charAt(i) != '-') {
            i++; 
        }        
        int value = Integer.valueOf(traversal.substring(index + depth , i));
        index = i;
        return value;
	}

}