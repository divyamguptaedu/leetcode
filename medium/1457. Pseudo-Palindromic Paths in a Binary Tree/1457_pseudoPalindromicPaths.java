"
Performance:
Runtime: 23 ms, faster than 44.80% of Java online submissions for Pseudo-Palindromic Paths in a Binary Tree.
Memory Usage: 103.2 MB, less than 36.71% of Java online submissions for Pseudo-Palindromic Paths in a Binary Tree.
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
    int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        List<Integer> list = new ArrayList();
        int[] frequency = new int[10];
        cal(root, frequency);
        return result;
    }
    
    private void cal(TreeNode root, int[] frequency) {
        if (root != null) {
            frequency[root.val]++;
            if (root.left == null && root.right == null) {
                if (helper(frequency)) {
                    result++;
                }
            }
            cal(root.left, frequency);
            cal(root.right, frequency);
            frequency[root.val]--;
        }
    }
    
    private boolean helper(int[] frequency) {
        int temp = 0;
        for (int i = 1; i < 10; i++) {
            if (frequency[i] % 2 == 1) {
                temp++;
                if (temp > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
