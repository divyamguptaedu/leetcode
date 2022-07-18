"
Performance:
Runtime: 706 ms, faster than 99.57% of Java online submissions for Construct Binary Tree from Preorder and Postorder Traversal.
Memory Usage: 231.2 MB, less than 89.84% of Java online submissions for Construct Binary Tree from Preorder and Postorder Traversal.
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
    private Map<Integer,Integer> valueMap = new HashMap<>();
    private int index;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(0, post.length - 1, pre, post);
    }
    
    private TreeNode helper(int low, int high, int[] pre, int[] post) {
        if (index == pre.length || low > high) {
            return null;
        }
        TreeNode root = new TreeNode(pre[index++]);
        if (low == high) {
            return root;
        }
        int temp = valueMap.get(pre[index]);
        root.left = helper(lo, temp, pre, post);
        root.right = helper(temp + 1, hi - 1, pre, post);
        return root;
    }
}