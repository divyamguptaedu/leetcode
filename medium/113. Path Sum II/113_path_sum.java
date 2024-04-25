//Used a recursive approach. 
//Make a main result list and a temporary list to keep track of nodes in the current path. 
//Copied over the list if the leaf nodes makes the remaining sum to be zero, removed the last node if not.
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
 //Time: O(n^2)
 //Space: O(n)
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        this.helper(root, sum, tempList, resultList);
        return resultList;
    }

    public void helper(TreeNode node, int sum, List<Integer> currentList, List<List<Integer>> resultList) {
        if (node == null) {
            return;
        }
        currentList.add(node.val);
        if (sum - node.val == 0 && node.left == null && node.right == null) { //leaf node with pathSum
            resultList.add(new ArrayList<>(currentList)); //need to copy over, O(n) operation
        } else {
            this.helper(node.left, sum - node.val, currentList, resultList);
            this.helper(node.right, sum - node.val, currentList, resultList);
        }

        currentList.remove(currentList.size() - 1); //remove last
    }
}