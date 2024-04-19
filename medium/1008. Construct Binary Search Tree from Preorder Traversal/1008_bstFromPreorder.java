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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end){
        if (start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[start], null, null);

        int nextPosition = start + 1;
        while (nextPosition <= end && preorder[nextPosition] < preorder[start]) {
            nextPosition++;
        }
        
        root.left = helper(preorder, start + 1, nextPosition - 1);
        root.right = helper(preorder, nextPosition, end);   
        
        return root;
    }
}