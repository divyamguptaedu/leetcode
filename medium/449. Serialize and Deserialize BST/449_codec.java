"""
Performance:
Runtime: 10 ms, faster than 69.49% of Java online submissions for Serialize and Deserialize BST.
Memory Usage: 47.1 MB, less than 76.61% of Java online submissions for Serialize and Deserialize BST.

"""

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        helperOne(root, result);
        return result.toString();
    }
    
    private void helperOne(TreeNode root, StringBuilder result) {
        if (root == null) {
            return;
        }
        result.append(root.val).append("-");
        helperOne(root.left, result);
        helperOne(root.right, result);
    }

    public TreeNode deserialize(String string) {
        if (string.length() == 0) {
            return null;
        }
        String[] result = string.split("-");
        return helperTwo(result, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helperTwo(String[] result, int[] index, int min, int max) {
        if (index[0] >= result.length || Integer.parseInt(result[index[0]]) < min || Integer.parseInt(result[index[0]]) > max) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(result[index[0]++]));
        node.left = helperTwo(result, index, min, node.val);
        node.right = helperTwo(result, index, node.val, max);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;