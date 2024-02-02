/*
Runtime: 1 ms, faster than 57.74% of Java online submissions for Cousins in Binary Tree.
Memory Usage: 42.4 MB, less than 15.21% of Java online submissions for Cousins in Binary Tree.
*/

/*
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
    public boolean isCousins(TreeNode root, int A, int B) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            boolean aSameLevel = false;
            boolean bSameLevel = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.val == A)
                    aSameLevel = true;
                if (current.val == B)
                    bSameLevel = true;
                if (current.left != null && current.right != null) {
                    if (current.left.val == A && current.right.val == B) {
                        return false;
                    }
                    if (current.left.val == B && current.right.val == A) {
                        return false;
                    }
                }
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            if (aSameLevel && bSameLevel)
                return true;
             else if (aSameLevel || bSameLevel)
                 return false;
        }
        return false;
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
class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        int xDepth = findDepth(root, x, 1);
        int yDepth = findDepth(root, y, 1);
        return !isSiblings(root, x, y) && (xDepth == yDepth);
    }
    public static boolean isSiblings(TreeNode root, int x, int y){
        if (root == null || (root.left == null && root.right == null)){
            return false;
        }
        if (root.left != null && root.right != null){
            if (((root.left.val == x || root.right.val == x) && (root.left.val == y || root.right.val == y))){
                return true;
            }
        } 
        return isSiblings(root.left, x, y) || isSiblings(root.right, x, y);
    }

    public static int findDepth(TreeNode root, int x, int depth){
        if (root == null || (root.left == null && root.right == null && root.val != x)){
            return -1;
        }
        if (root.val == x){
            return depth;
        }
        int leftCheck = findDepth(root.left, x, depth + 1);
        int rightCheck = findDepth(root.right, x, depth + 1);
        return leftCheck !=  -1 ? leftCheck : rightCheck;
    }
}
