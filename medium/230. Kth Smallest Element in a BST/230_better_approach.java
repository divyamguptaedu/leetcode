"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
Memory Usage: 42.6 MB, less than 5.59% of Java online submissions for Kth Smallest Element in a BST.
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
        inOrderTraverse(list, root, k);
        return list.get(k - 1);
    }

    private void inOrderTraverse(List<Integer> list, TreeNode root, int k) {
      if (root == null) {
        return;
      }
      // stops the recursion once we have found the kth element
      if (list.size() == k) {
        return;
      }
      inOrderTraverse(list, root.left, k);
      list.add(root.val);
      inOrderTraverse(list, root.right, k);
    }
}