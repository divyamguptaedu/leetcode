"
Performance:
Runtime: 2 ms, faster than 99.70% of Java online submissions for Vertical Order Traversal of a Binary Tree.
Memory Usage: 39.2 MB, less than 50.22% of Java online submissions for Vertical Order Traversal of a Binary Tree.
"

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
    int minimum = 0;
    int maximum = 0;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<TreeNode, Integer> columnMap = new HashMap<>();
        dfs(root, 0, columnMap);
        return helper(root, columnMap);
    }
    
    private List<List<Integer>> helper(TreeNode root, Map<TreeNode, Integer> columnMap) {
        int total = maximum - minimum + 1;
        List<List<List<Integer>>> verticalList = new ArrayList<>(total);
        for (int c = 0; c < total; c++) {
            verticalList.add(new ArrayList<>());
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                TreeNode node = queue.poll();
                int column = columnMap.get(node);
                List<List<Integer>> columnList = verticalList.get(column - minimum);
                while (columnList.size() <= level) {
                    columnList.add(new ArrayList<>());
                }
                List<Integer> nodeList = columnList.get(level);
                nodeList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        List<List<Integer>> res = new ArrayList<>(total);
        for (List<List<Integer>> columnList : verticalList) {
            List<Integer> vertical = new ArrayList<>();
            for (List<Integer> nodeList : columnList) {
                Collections.sort(nodeList);
                vertical.addAll(nodeList);
            }
            res.add(vertical);
        }
        return res;
    }
    
    private void dfs(TreeNode root, int column, Map<TreeNode, Integer> columnMap) {
        if (root == null) {
            return;
        }
        columnMap.put(root, column);
        dfs(root.left, column - 1, columnMap);
        dfs(root.right, column + 1, columnMap);
        minimum = Math.min(minimum, column);
        maximum = Math.max(maximum, column);
    }
}