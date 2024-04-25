/**
Used DFS because we need to go to the leaf node directly. 
Because we want the left node after the root, pre-order works the best. 
Ensured that I am keeping track of the number by multiplying the number by 10 
and then adding the value of the current node. 
Made sure to add the number to the result if there are no child nodes of a particular node.
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
//Space: O(h) : h is the height of the tree, recursion stack.
class Solution {
    int output = 0;
    
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return output;
    }

    public void preorder(TreeNode node, int numberSoFar) {
        if (node != null) {
            numberSoFar = numberSoFar * 10 + node.val;
            if (node.left == null && node.right == null) { //add to the result if no childs present
                output += numberSoFar;
            }
            preorder(node.left, numberSoFar);
            preorder(node.right, numberSoFar) ;
        }
    }
}