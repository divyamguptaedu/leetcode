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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        findPathSum(root, targetSum, result, list);
        return result;  
    }

    private void findPathSum(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(list));
        }
        findPathSum(node.left, targetSum - node.val, result, list);
        findPathSum(node.right, targetSum - node.val, result, list);
        list.remove(list.size() - 1);
    }
}