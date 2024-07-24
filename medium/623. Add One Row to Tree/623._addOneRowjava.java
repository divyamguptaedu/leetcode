//Used a BFS strategy level by level to have a queue of the required depth nodes, 
//then just fixed the left and the right by adding a new row in between and fixing the connections.
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
 //Space: O(x) : x is the max number of nodes in a level
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) { //if the depth at which the row is to be added is the top
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue <TreeNode> queue = new LinkedList <>();
        queue.add(root);
        int currentDepth = 1;
        while (currentDepth < depth - 1) {
            Queue <TreeNode> internalQueue = new LinkedList <>(); //to consider the current level
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    internalQueue.add(node.left);
                }
                if (node.right != null) {
                    internalQueue.add(node.right);
                }
            }
            queue = internalQueue;
            currentDepth++;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            //fix the left
            TreeNode temp = node.left; //save the left
            node.left = new TreeNode(val); //set the new left
            node.left.left = temp; //set the old left to the left of the new node

            //fix the right
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }
}

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            if (depth == 1) {
                return new TreeNode(val);
            }
            return null;
        }
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentDepth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (currentDepth == depth - 1) {
                    TreeNode originalLeft = node.left;
                    TreeNode originalRight = node.right;
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                    node.left.left = originalLeft;
                    node.right.right = originalRight;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            currentDepth++;
        }
        return root;
    }
}