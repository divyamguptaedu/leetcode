//Used a simple recursive approach. 
//Checked if two nodes are identical by checking their values and recursing on their child nodes.
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
 //Time: O(mn) where m is the number of nodes in tree A and n is #nodes in tree B
 //Space: O(m+n)
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubtreeHelper(root, subRoot);
    }

    private boolean isSubtreeHelper(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (isEqual(subRoot, root)) {
                return true;
            }
        }
        return isSubtreeHelper(root.left, subRoot) || isSubtreeHelper(root.right, subRoot);
    }

    private boolean isEqual(TreeNode subRoot, TreeNode root) {
        if (subRoot == null && root == null) {
            return true;
        }
        if (subRoot == null) {
            return false;
        }
        if (root == null) {
            return false;
        }
        if (subRoot.val != root.val) {
            return false;
        }
        return isEqual(subRoot.left, root.left) && isEqual(subRoot.right, root.right);

    }
}

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        }
        return node1.val == node2.val && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }
}