/**
Used a binary search approach to iterate the tree conditionally. 
Made sure include the logic to determine the node with the closest value. 
Also made sure to return the smallest node if there are multiple answers.
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

 //Time: O(h) h is the height of the tree
 //Space: O(1)
class Solution {
    public int closestValue(TreeNode root, double target) {
        int currentValue = root.val;
        int closestValue = root.val;
        while (root != null) {
            currentValue = root.val;
            if (Math.abs(currentValue - target) < Math.abs(closestValue - target)) {
                closestValue = currentValue;
            }
            if ((Math.abs(currentValue - target) == Math.abs(closestValue - target) && currentValue < closestValue)) {
                closestValue = currentValue;
            }
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closestValue;
    }
}