//Used simple pre-order traversal to convert traversal into string including null values, 
//and then just decoded it back to the BST for deserialization.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Time: O(n)
 //Space: O(n)
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializerHelper(root, "");
    }

    public String serializerHelper(TreeNode root, String result) { //preorder traversal approach
        if (root == null) {
            result += "null,";
        } else {
            result += result.valueOf(root.val) + ","; //convert int to string
            result = serializerHelper(root.left, result);
            result = serializerHelper(root.right, result);
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] stringNodesArray = data.split(",");
        List<String> input = new LinkedList<String>(Arrays.asList(stringNodesArray));
        return deserializerHelper(input);
    }

    public TreeNode deserializerHelper(List<String> input) {
        if (input.get(0).equals("null")) {
            input.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(input.get(0))); //convert string to int
        input.remove(0);
        root.left = deserializerHelper(input);
        root.right = deserializerHelper(input);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));