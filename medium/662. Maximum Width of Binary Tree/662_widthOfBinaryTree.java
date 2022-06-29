"
Performance:
Runtime: 3 ms, faster than 53.10% of Java online submissions for Maximum Width of Binary Tree.
Memory Usage: 44.4 MB, less than 12.71% of Java online submissions for Maximum Width of Binary Tree.
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
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int maxWidth = Integer.MIN_VALUE;
    public int widthOfBinaryTree(TreeNode root) {
        helper(root, 0, 0);
        return maxWidth;
    }
    
    public void helper (TreeNode root, int depth, int position) {
        if (root == null) {
            return;
        }
        if (!hashMap.containsKey(depth)) {
            hashMap.put(depth, position);
        }       
        maxWidth = Math.max(maxWidth, position - hashMap.get(depth) + 1);
        helper(root.left, depth + 1, 2 * position);
        helper(root.right,depth + 1, 2 * position + 1);
    }
}