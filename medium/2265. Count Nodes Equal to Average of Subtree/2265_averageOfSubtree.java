//Used simple recursive solution DFS in which the node value and node count is calculated using the left node, 
//right node, and current node. Based on the average, the overall count is modified.
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
//Space: O(n)
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
    int count;
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        traverse(root);
        return count;
    }

    private Pair<Integer, Integer> traverse(TreeNode node) {
        if (node == null) {
            return new Pair(0, 0);
        }
        Pair<Integer, Integer> leftInfo = traverse(node.left);
        Pair<Integer, Integer> rightInfo = traverse(node.right);
        int sum = leftInfo.getKey() + rightInfo.getKey() + node.val;
        int numNodes = leftInfo.getValue() + rightInfo.getValue() + 1;
        if (sum / numNodes == node.val) {
            count++;
        }
        return new Pair(sum, numNodes);

    }
}