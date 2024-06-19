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

//I defined a helper function that recursively traversed the left subtree, then the right subtree, and finally added the current node's value to the output list. 
//This function was called by the main method which returned the populated list. 
//Postorder traversal processes nodes in left-right-root order, ensuring all child nodes are processed before their parent nodes.
//Time: n
//Space: n
class Solution {
    public void postorder(TreeNode root, List<Integer> output) {
        if (root == null) return;
        postorder(root.left, output);
        postorder(root.right, output);
        output.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList();
        postorder(root, output);
        return output;
    }
}