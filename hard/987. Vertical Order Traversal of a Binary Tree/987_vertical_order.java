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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>(); //(col, (row, nodeVal))
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>(); //(node, (row, col))
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int minCol = 0;
        int maxCol = 0;
        int row = 0;
        int col = 0;
        queue.add(new Pair(root, new Pair(row, col)));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> node = queue.poll();
            root = node.getKey();
            row = node.getValue().getKey();
            col = node.getValue().getValue();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Pair<Integer, Integer>>());
            }
            map.get(col).add(new Pair(row, root.val));
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            if (root.left != null) {
                queue.add(new Pair(root.left, new Pair(row + 1, col - 1)));
            }
            if (root.right != null) {
                queue.add(new Pair(root.right, new Pair(row + 1, col + 1)));
            }
        }
        for (int i = minCol; i <= maxCol; i++) {
            Collections.sort(map.get(i), new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                    if (p1.getKey() == p2.getKey()) { //if same rows, then sort by value
                        return p1.getValue() - p2.getValue();
                    } else {
                        return p1.getKey() - p2.getKey();
                    }
                }
            });
            List<Integer> tempList = new ArrayList<>();
            for (Pair<Integer, Integer> p : map.get(i)) {
                tempList.add(p.getValue());
            }
            result.add(tempList);
        }
        return result;
    }
}