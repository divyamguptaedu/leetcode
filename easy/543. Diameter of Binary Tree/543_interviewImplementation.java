// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfsHelper(root);
        return diameter;
    }

    private int dfsHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPath = dfsHelper(root.left);  // Recursive call to get height of left subtree
        int rightPath = dfsHelper(root.right); // Recursive call to get height of right subtree

        // Update the diameter if the path through the current node is longer
        diameter = Math.max(diameter, leftPath + rightPath);

        // Return the height of the current node
        return Math.max(leftPath, rightPath) + 1;
    }

    // Main method to test the Solution class
    public static void main(String[] args) {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + result);
    }
}
