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
    int resultMax = 0;
    public int maxSumBST(TreeNode n) {
        resultMax = 0;
        dfs(n);
        return resultMax;
    }
    
    class Pair {
        int sum;
        int max;
        int min;
        boolean isBst;

        public Pair (int s) {
            sum = s;
        }

        public Pair(int s, boolean b, int leftMax, int rightMin) {
            sum = s;
            isBst = b;
            max = leftMax; 
            min = rightMin;
        }
    }

    public Pair dfs(TreeNode n) {
        if (n == null) {
            return new Pair(0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        if (n.left == null && n.right == null) { //leaf node
            if (resultMax < n.val) {
                resultMax = n.val;
            }
            return new Pair(n.val, true, n.val, n.val);
        }
        
        Pair leftPair = dfs(n.left);
        Pair rightPair = dfs(n.right);

        Pair nodePair = new Pair(leftPair.sum + rightPair.sum + n.val); //calculate sum
        if (n.val > leftPair.max && n.val < rightPair.min && leftPair.isBst && rightPair.isBst) { //bst conditions
            nodePair.isBst = true;
            if (resultMax < nodePair.sum) { //update resultMax
                resultMax = nodePair.sum; 
            }
        } else {
            nodePair.isBst = false;
        }
        nodePair.min = Math.min(n.val, leftPair.min);
        nodePair.max = Math.max(n.val, rightPair.max);
        return nodePair;
    }
}