//Used a simple recursive approach. 
//Checked if two nodes are identical by checking their values and recursing on their child nodes.
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
 //Time: O(mn) where m is the number of nodes in tree A and n is #nodes in tree B
 //Space: O(m+n)
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        } 
        if (helper(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }
     
    //if the two nodes are identical (recursive implementation on child nodes)
    public boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true; 
        }
        return (root1 != null && root2 != null && root1.val == root2.val) && helper(root1.left , root2.left) && helper(root1.right , root2.right);
    }
}
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            boolean result = isSame(root, subRoot);
            if (result) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSame(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }
        return isSame(r1.left, r2.left) && isSame(r1.right, r2.right);
    }
}