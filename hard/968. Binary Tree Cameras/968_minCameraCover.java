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
 //Space: O(h) h is the height of the tree
class Solution {
    int count = 0;
    public int minCameraCover(TreeNode root) {
        // 0 -> need camera
        // 1 -> is camera
        // 2 -> has surveillance
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        if (solve(root) == 0) {
            count++;
        }
        return count;
    }
    
    public int solve(TreeNode node){
        if (node == null) { //if a node doesn't exist, that means it has surveillance
            return 2;
        }
            
        int left = solve(node.left);
        int right = solve(node.right);
        
        if (left == 0 || right == 0) { // even if one needs a camera then I put a camera
            count++;
            return 1;       
            
        } else if (left == 1 || right == 1) { // even if one has a camera then I'm safe
            return 2;    
            
        } else { // if both are surveilled then I need a camera
            return 0;
        }
    }
}