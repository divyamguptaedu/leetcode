"
Performance:
Runtime: 2 ms, faster than 18.06% of Java online submissions for Binary Tree Cameras.
Memory Usage: 38.6 MB, less than 87.25% of Java online submissions for Binary Tree Cameras.
"

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
    int count = 0;
    HashSet<TreeNode> set = new HashSet<TreeNode>();
    
    public int minCameraCover(TreeNode root) {
        set.add(null);
        helper(root, null);
        return count;
    }
    
    private void helper(TreeNode root, TreeNode parent){
        if (root == null) {
            return;   
        }
        
        helper(root.left, root);
        helper(root.right, root);
        
        if (parent == null 
            && set.contains(root) == false 
            || set.contains(root.left) == false 
            || set.contains(root.right) == false) {
            
            count++;
            set.add(root);
            set.add(root.left);
            set.add(root.right);
            set.add(parent);
        }
    }
}