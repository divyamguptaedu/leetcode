"
Performance:
Runtime: 19 ms, faster than 18.01% of Java online submissions for Binary Search Tree Iterator.
Memory Usage: 49.3 MB, less than 5.97% of Java online submissions for Binary Search Tree Iterator.
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

    ArrayList<Integer> values;
    int index = -1;

    public BSTIterator(TreeNode root) {
        this.values = new ArrayList<Integer>();
        this.inorderTraversal(root);
    }

    public int next() {
        this.index++;
        return this.values.get(index);
    }

    public boolean hasNext() {
        return (this.index + 1 < this.values.size());
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        this.inorderTraversal(root.left);
        this.values.add(root.val);
        this.inorderTraversal(root.right);
    }
}