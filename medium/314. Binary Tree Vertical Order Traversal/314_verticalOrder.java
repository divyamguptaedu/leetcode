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
//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        HashMap<Integer, ArrayList<Integer>> columnMap = new HashMap();
        int column = 0;
        int minColumn = 0; //keep track of min
        int maxColumn = 0; //keep track of max

        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        queue.offer(new Pair(root, column));

        while (!queue.isEmpty()) { //bfs with pair of node and col
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            column = pair.getValue();

            if (root != null) {
                if (!columnMap.containsKey(column)) {
                    columnMap.put(column, new ArrayList<Integer>());
                }
                columnMap.get(column).add(root.val);
                minColumn = Math.min(column, minColumn);
                maxColumn = Math.max(column, maxColumn);
                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) { //building the output using the map
            output.add(columnMap.get(i));
        }

        return output;
    }
}