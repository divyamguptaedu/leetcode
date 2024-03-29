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

//another solution

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
class BSTIterator {
    List<Integer> list;
    int next = 0;

    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        helper(root);
    }
    
    public int next() {
        return  list.get(next++);
    }
    
    public boolean hasNext() {
        return list.size() > next;
    }
   
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */