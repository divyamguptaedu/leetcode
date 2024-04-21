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
 //Time: O(2^(n/2))
 //Space: O(n.(2^(n/2)))
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0 || n % 2 == 0) {
            return result;
        }
        
        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        
        for (int i = 1 ; i < n ; i += 2) {
            int node = n - 1 - i; //so that left and right can sum up to n - 1
            List<TreeNode> leftTree = allPossibleFBT(i);
            List<TreeNode> rightTree = allPossibleFBT(node);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}