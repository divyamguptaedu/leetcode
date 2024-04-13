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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList();
        if (root == null) {
            return output;
        }
        
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque();
        nextLevel.offer(root);
        ArrayDeque<TreeNode> currentLevel = new ArrayDeque();        
        
        TreeNode currentNode = null;

        while (!nextLevel.isEmpty()) {
            // prepare for the next level
            currentLevel = nextLevel;
            nextLevel = new ArrayDeque<>();

            while (! currentLevel.isEmpty()) {
                currentNode = currentLevel.poll();
                if (currentNode.left != null) {
                    nextLevel.offer(currentNode.left); //add left child to the next level
                }    
                if (currentNode.right != null) { 
                    nextLevel.offer(currentNode.right); //add right child to the next level
                }
            }
            
            if (currentLevel.isEmpty()) 
                output.add(currentNode.val); //add last node of the current level to the result
        }
        return output;
    }
}