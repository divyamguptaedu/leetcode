"
Performance:
Runtime: 15 ms, faster than 70.65% of Java online submissions for Binary Search Tree Iterator.
Memory Usage: 42.4 MB, less than 81.98% of Java online submissions for Binary Search Tree Iterator.
"

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class BSTIterator {
    TreeNode currrent;
    Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        currrent = root;
        
        while(currrent != null){
            stack.push(currrent);
            currrent = currrent.left;
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        TreeNode temp = node.right;
        
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}