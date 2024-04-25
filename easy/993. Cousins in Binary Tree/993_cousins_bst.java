//Used a simple BFS traversal approach in which if the x and y are siblings, 
//then false is returned. Otherwise, their height is saved. 
//In the end, the height is checked if it is the same.
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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return false;
        }
        queue.add(root);
        int depthOfX = Integer.MIN_VALUE;
        int depthOfY = Integer.MIN_VALUE;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size ; i++) {
                TreeNode currentNode = queue.remove();
                if (currentNode.left != null && currentNode.right != null) {
                    if ((currentNode.left.val == x && currentNode.right.val == y) || (currentNode.left.val == y && currentNode.right.val == x)) {
                        return false;
                    }
                }
                if (currentNode.val == x) {
                    depthOfX = level;
                }
                if (currentNode.val == y) {
                    depthOfY = level;
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            level++;
        }
        return depthOfX == depthOfY;
    }
}