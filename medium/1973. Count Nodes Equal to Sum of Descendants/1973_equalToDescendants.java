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
    public int equalToDescendants(TreeNode root) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek();
                if (temp.right != null && temp.right != lastVisited) {
                    current = temp.right;
                } else {
                    temp = stack.pop();
                    lastVisited = temp;
                    int left = 0;
                    int right = 0;
                    int nodeVal = temp.val;
                    if (temp.left != null) {
                        left = temp.left.val;
                    }
                    if (temp.right != null) {
                        right = temp.right.val;
                    }
                    if (nodeVal == left + right) {
                        count++;
                    }
                    temp.val = nodeVal + left + right;
                }
            }
        }
        return count;
    }
}

// class Solution {
//     int count;
//     public int equalToDescendants(TreeNode root) {
//         count = 0;
//         traverse(root);
//         return count;
//     }

//     private int traverse(TreeNode node) {
//         if (node == null) {
//             return 0;
//         }
//         int left = traverse(node.left);
//         int right = traverse(node.right);
//         int nodeValue = node.val;
//         if (nodeValue == left + right) {
//             count++;
//         }
//         return left + right + node.val;
//     }
// }