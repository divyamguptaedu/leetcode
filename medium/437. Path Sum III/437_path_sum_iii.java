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
    int count = 0;
    int k;
    HashMap<Long, Integer> map = new HashMap();
    
    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        helper(root, 0L);
        return count;
    }

    public void helper(TreeNode node, long currSum) {
        if (node == null) {
            return;
        }
        
        currSum += node.val;

        if (currSum == k) {
            count++; //represents root to node sum which is equal to the target
        }
            
        count += map.getOrDefault(currSum - k, 0); //represents a middle path

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        helper(node.left, currSum);
        helper(node.right, currSum);
        map.put(currSum, map.get(currSum) - 1);
    }
}