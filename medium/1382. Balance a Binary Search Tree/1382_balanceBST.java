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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<>();
        inorder(root, array);
        return inorderToBST(0, array.size() - 1, array);
    }

    public void inorder(TreeNode root, ArrayList<Integer> array) {
        if (root == null) {
            return;
        }
        inorder(root.left, array);
        array.add(root.val);
        inorder(root.right, array);
    }

    public TreeNode inorderToBST(int start, int end, ArrayList<Integer> array) {
        if (start > end) {
            return null;
        }

        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(array.get(middle));
        root.left = inorderToBST(start, middle - 1, array);
        root.right = inorderToBST(middle + 1, end ,array);
        return root;
    }
}