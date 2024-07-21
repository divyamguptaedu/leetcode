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
    TreeNode root;
    TreeNode nodeP;
    TreeNode nodeQ;
    public int findDistance(TreeNode root, int p, int q) {
        this.root = root;
        TreeNode lca = findLCA(p, q);
        int depthP = findDepth(lca, p);
        int depthQ = findDepth(lca, q);
        return depthP + depthQ;
    }

    private TreeNode findLCA(int p, int q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parents.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parents.put(node.right, node);
                queue.add(node.right);
            }
            if (node.val == p) {
                this.nodeP = node;
            }
            if (node.val == q) {
                this.nodeQ = node;
            }
        }
        HashSet<TreeNode> ancestors = new HashSet<>();
        TreeNode node = nodeP;
        while (node != null) {
            ancestors.add(node);
            node = parents.get(node);
        }
        node = nodeQ;
        while (!ancestors.contains(node)) {
            node = parents.get(node);
        }
        return node;
    }

    private int findDepth(TreeNode start, int target) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(start, 0));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            Integer depth = pair.getValue();
            if (node.val == target) {
                return depth;
            }
            if (node.left != null) {
                stack.add(new Pair(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.add(new Pair(node.right, depth + 1));
            }
        }
        return -1;
    }
}