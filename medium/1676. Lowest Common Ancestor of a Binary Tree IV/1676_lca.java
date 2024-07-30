class Solution {
    TreeNode ans;
    Boolean found = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        HashSet<TreeNode> set = new HashSet<>();
        for (TreeNode n : nodes) {
            set.add(n);
        }
        this.recurseTree(root, set);
        return this.ans;
    }

    private int recurseTree(TreeNode currentNode, Set<TreeNode> nodes) {
        if (currentNode == null) {
            return 0;
        }

        int mid = nodes.contains(currentNode) ? 1 : 0;
        int left = this.recurseTree(currentNode.left, nodes);
        int right = this.recurseTree(currentNode.right, nodes);

        if (!found && mid + left + right >= nodes.size()) {
            this.ans = currentNode;
            this.found = true;
        }
        return mid + left + right;
    }
}

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
//         if (root == null) {
//             return null;
//         }
//         for (TreeNode node : nodes) {
//             if (root == node) {
//                 return root;
//             }
//         }
//         TreeNode left = lowestCommonAncestor(root.left, nodes);
//         TreeNode right = lowestCommonAncestor(root.right, nodes);
//         if (left != null && right != null) {
//             return root;
//         } else if (left == null && right == null) {
//             return null;
//         } else if (left == null) {
//             return right;
//         } else {
//             return left;
//         }
//     }
// }