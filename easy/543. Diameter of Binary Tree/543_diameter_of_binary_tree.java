/**
Used DFS because that we can calculate the height bottom to up. 
After recursing on left and right, when it comes to the actual node, 
we add the height of the left and right and add one to it to get the max diameter till there. 
We update the diameter when we find that the left+right is higher than the currDiameter.
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
 //Time: O(n)
 //Space: O(n) //recursion stack
class Solution {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
    private int dfs(TreeNode node){
        if (node == null) {
            return 0;
        }
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        //update the diameter
        diameter = Math.max(diameter, leftPath + rightPath); //if the right+left height is > than currDiameter, then update it.

        return Math.max(leftPath, rightPath) + 1; //actual logic, for every node, get the height of the left node, then height of the right node, add one to find the height of the currNode.
    }
}

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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        this.diameter = 0;
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}