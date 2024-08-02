"""
Performance:
Runtime: 3 ms, faster than 64.66% of Java online submissions for Recover Binary Search Tree.
Memory Usage: 47.7 MB, less than 22.37% of Java online submissions for Recover Binary Search Tree.
"""

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// class Solution {
//     private void swap(TreeNode a, TreeNode b) {
//         int temp = a.val;
//         a.val = b.val;
//         b.val = temp;
//     }

//     public void recoverTree(TreeNode root) {
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode x = null;
//         TreeNode y = null;
//         TreeNode temp = null;
//         while (!stack.isEmpty() || root != null) {
//             while (root != null) {
//                 stack.add(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             if (temp != null && root.val < temp.val) {
//                 y = root;
//                 if (x == null) {
//                     x = temp;
//                 } else {
//                     break;
//                 }
//             }
//             temp = root;
//             root = root.right;
//         }
//         swap(x, y);
//     }
// }

class Solution {
    TreeNode x = null;
    TreeNode y = null;
    TreeNode prev = null;


    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);
    }

    private void findTwoSwapped(TreeNode current) {
        if (current == null) {
            return;
        }
        findTwoSwapped(current.left);
        if (prev != null && current.val < prev.val) {
            y = current;
            if (x == null) {
                x = prev;
            } else {
                return;
            }
        }
        prev = current;
        findTwoSwapped(current.right);
    }

    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
