//Used a simple interative BFS approach, using the length of the queue at each level and a maxInThisRow pointer.
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
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int currentLength = queue.size();
            int maxInThisRow = Integer.MIN_VALUE;
            
            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                maxInThisRow = Math.max(maxInThisRow, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(maxInThisRow);
        }
        
        return result;
    }
}