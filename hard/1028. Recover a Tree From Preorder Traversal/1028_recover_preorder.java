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
    int i = 0; //index
    String traversal;

    public TreeNode recoverFromPreorder(String traversal) {
        this.traversal = traversal;
        int[] next = getNext();
        TreeNode root = new TreeNode(next[0]);

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));

        while (i < traversal.length()) {
            int[] n = getNext();
            TreeNode temp = new TreeNode(n[0]);
            while (stack.peek().getValue() != n[1]) { //get the node which can be temp's child
                stack.pop();
            }

            if (stack.peek().getKey().left == null) { //if the left is null, then put there
                stack.peek().getKey().left = temp;
            } else {
                stack.peek().getKey().right = temp; //if left is not empty, then put on the right
            }

            stack.push(new Pair(temp, n[1] + 1)); //add this new node and it's child's expected level to the stack
        }

        return root;
    }

    public int[] getNext() {
        int level = 0;
        StringBuffer sb = new StringBuffer();

        while (i < traversal.length() && traversal.charAt(i) == '-') {
            i++;
            level++;
        }

        while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
            sb.append(traversal.charAt(i));
            i++;
        }

        return new int[] {Integer.parseInt(sb.toString()), level};
    }
}