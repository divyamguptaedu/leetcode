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
class CBTInserter {
    TreeNode root;
    public CBTInserter(TreeNode root) {
        root = root;
    }
    
    public int insert(int val) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> current = new ArrayList<TreeNode>();
            while (!queue.isEmpty()) {
                current.add(queue.poll());
            }
            for (TreeNode node : current) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return node.val;
                }
                queue.add(node.left);
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return node.val;
                }
                queue.add(node.right);
            }
        }
        return Integer.MIN_VALUE;
    }
    
    public TreeNode get_root() {
        return root;
    }
}


/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */