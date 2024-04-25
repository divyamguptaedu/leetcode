//Used a simple BFS traversal approach in which I added the values of the grandchildren 
//to the sum variable if the parent's value is even. 
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
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if (currentNode.val % 2 == 0) {
                if (currentNode.left != null) {
                    if (currentNode.left.left != null) {
                        sum += currentNode.left.left.val;
                    }
                    if (currentNode.left.right != null) {
                        sum += currentNode.left.right.val;
                    }
                }
                if (currentNode.right != null) {
                    if (currentNode.right.left != null) {
                        sum += currentNode.right.left.val;
                    }
                    if (currentNode.right.right != null) {
                        sum += currentNode.right.right.val;
                    }
                }
            }

            if (currentNode.left != null) 
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
        
        return sum;
    }
}