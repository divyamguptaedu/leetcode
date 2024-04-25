//Used level order traversal while assigning nodes a number at each level starting at 0.
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
class Pair {
    TreeNode node;
    int num;
    Pair (TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
} 
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size(); //to account of the level size
            int temp = queue.peek().num;
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                int currentId = queue.peek().num - temp;
                TreeNode node = queue.peek().node;
                queue.poll();
                if (i == 0) {
                    first = currentId;
                }
                if (i == size - 1) {
                    last = currentId;
                }
                if (node.left != null) {
                    queue.offer(new Pair(node.left, currentId * 2 + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, currentId * 2 + 2));
                }
            }
            answer = Math.max(answer, last - first + 1);
        }
        return answer;
    }
}