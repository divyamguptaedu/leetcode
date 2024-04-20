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
 //Time: CBTInserter - O(n), insert() - O(1), get_root() - O(1)
 //Space: O(n)
class CBTInserter {
    List<TreeNode> mainList;

    public CBTInserter(TreeNode root) {
        mainList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                mainList.add(currentNode);
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);          
            } 
        }
    }
    
    public int insert(int val) {
        mainList.add(new TreeNode(val)); 
        int index = mainList.size() - 1;
        int parentIndex = (index - 1) / 2; 
        if (mainList.get(parentIndex).left == null) {
            mainList.get(parentIndex).left = mainList.get(index);
        } else if (mainList.get(parentIndex).right == null) {
            mainList.get(parentIndex).right = mainList.get(index);
        }
        return mainList.get(parentIndex).val;      
    }
    
    public TreeNode get_root() {
        return mainList.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */