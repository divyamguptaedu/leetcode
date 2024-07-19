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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        parentMap.put(root, null);

        List<TreeNode> deepestLeaves = new ArrayList<>();
        while (!queue.isEmpty()) {
            deepestLeaves.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                deepestLeaves.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                    parentMap.put(node.left, node);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    parentMap.put(node.right, node);
                }
            }
        }

        while (deepestLeaves.size() > 1) {
            Set<TreeNode> parents = new HashSet<>();
            for (TreeNode node : deepestLeaves) {
                parents.add(parentMap.get(node));
            }
            deepestLeaves = new ArrayList<>(parents);
        }

        return deepestLeaves.get(0);
    }
}
