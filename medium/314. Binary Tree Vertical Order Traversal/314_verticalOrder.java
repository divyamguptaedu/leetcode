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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int column = 0;
        int minCol = 0;
        int maxCol = 0;
        queue.add(new Pair(root, column));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            root = curr.getKey();
            column = curr.getValue();
            if (!map.containsKey(column)) {
                map.put(column, new ArrayList<>());
            }
            map.get(column).add(root.val);
            minCol = Math.min(minCol, column);
            maxCol = Math.max(maxCol, column);
            if (root.left != null) {
                queue.add(new Pair(root.left, column - 1));
            }
            if (root.right != null) {
                queue.add(new Pair(root.right, column + 1));
            }
        }
        for (int i = minCol; i <= maxCol; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}