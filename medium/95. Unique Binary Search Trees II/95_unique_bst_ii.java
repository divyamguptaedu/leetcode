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
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n) ;
    }
    
    public List<TreeNode> solve(int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if (left > right) {
            result.add(null) ;
            return result;
        }
        for (int i = left; i <= right ; i++) {
            List<TreeNode> leftSubtree = solve(left, i - 1) ;
            List<TreeNode> rightSubtree = solve(i + 1, right) ;
            for (TreeNode leftNode : leftSubtree) {
                for (TreeNode rightNode : rightSubtree) {
                    result.add(new TreeNode(i, leftNode, rightNode)) ;
                }
            }
        }
        return result;
    }
}
