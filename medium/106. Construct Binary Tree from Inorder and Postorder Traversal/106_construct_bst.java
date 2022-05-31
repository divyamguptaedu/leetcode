/*
Runtime: 4 ms, faster than 50.26% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
Memory Usage: 44.6 MB, less than 37.53% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
*/

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueMap.put(inorder[i], i);
        }
        index = postorder.length - 1;
        return helper(inorder, postorder, valueMap, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, HashMap<Integer, Integer> valueMap, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index--]);
        int position = valueMap.get(root.val);
        root.right = helper(inorder, postorder, valueMap, position + 1, end);
        root.left = helper(inorder, postorder, valueMap, start, position - 1);
        return root;
    }
}