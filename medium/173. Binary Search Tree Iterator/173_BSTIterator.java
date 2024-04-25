/**
Just did the inorder traversal during initialization and then returned the next and hasNext results in O(1) time.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

//Time: O(1) for the hasNext and next. O(n) for initialization.
//Space: O(n)
class BSTIterator {
    ArrayList<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<Integer>();
        index = -1;
        inorder(root);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public int next() {
        index++;
        return list.get(index);
    }

    public boolean hasNext() {
        return index + 1 < list.size();
    }
}






