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
 //Recursion Approach
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

//BFS Approach
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            height++;
            while (size-- > 0) {
                TreeNode temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return height;
    }
}

//DFS Approach
class Solution {
    int maxHeight = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return maxHeight;
    }
    public void dfs(TreeNode root, int currHeight) {
        maxHeight = Math.max(maxHeight, currHeight);
        if (root == null) {
            return;
        }
        currHeight++;
        dfs(root.left, currHeight);
        dfs(root.right, currHeight);
    }
}
