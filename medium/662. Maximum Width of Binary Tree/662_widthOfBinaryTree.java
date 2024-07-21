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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 1;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int maxWidth = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.peek();
            TreeNode head = pair.getKey();
            int headId = pair.getValue();
            int size = queue.size();
            Pair<TreeNode, Integer> currPair;
            TreeNode currNode;
            int currId = 0;
            for (int i = 0; i < size; i++) {
                currPair = queue.poll();
                currNode = currPair.getKey();
                currId = currPair.getValue();
                if (currNode.left != null) {
                    queue.add(new Pair(currNode.left, currId * 2));
                }
                if (currNode.right != null) {
                    queue.add(new Pair(currNode.right, currId * 2 + 1));
                }
            }
            if (currId - headId + 1 > maxWidth) {
                maxWidth = currId - headId + 1;
            }
        }
        return maxWidth;
    }
}