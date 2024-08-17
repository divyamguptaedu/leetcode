import java.util.*;

class BinaryTreePostOrderSerialization {
    // Serialize the tree using post-order traversal
    public String serialize(TreeNode root) {
        List<String> postOrderList = new ArrayList<>();
        serializeHelper(root, postOrderList);
        return String.join(",", postOrderList);
    }

    private void serializeHelper(TreeNode node, List<String> postOrderList) {
        if (node == null) {
            postOrderList.add("#");  // Use "#" to denote null nodes
            return;
        }
        serializeHelper(node.left, postOrderList);
        serializeHelper(node.right, postOrderList);
        postOrderList.add(String.valueOf(node.val));
    }

    // Deserialize the tree using post-order traversal
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        ArrayList<String> nodes = new ArrayList<>(Arrays.asList(data.split(",")));
        Collections.reverse(nodes);  // Reverse to process in post-order
        int[] index = new int[]{0};  // Use an array to keep the index mutable across recursive calls
        return deserializeHelper(nodes, index);
    }

    private TreeNode deserializeHelper(ArrayList<String> nodes, int[] index) {
        if (index[0] >= nodes.size()) {
            return null;
        }
        String val = nodes.get(index[0]);
        index[0]++;
        if (val.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.right = deserializeHelper(nodes, index);  // Process right subtree first
        root.left = deserializeHelper(nodes, index);   // Then process left subtree
        return root;
    }

    // Example usage and test cases
    public static void main(String[] args) {
        BinaryTreePostOrderSerialization serDeser = new BinaryTreePostOrderSerialization();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serializedTree = serDeser.serialize(root);
        System.out.println("Serialized Tree: " + serializedTree);

        TreeNode deserializedRoot = serDeser.deserialize(serializedTree);
        System.out.println("Deserialized Tree: ");
        printTreePostOrder(deserializedRoot);
    }

    // Helper function to print tree in post-order traversal
    private static void printTreePostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printTreePostOrder(node.left);
        printTreePostOrder(node.right);
        System.out.print(node.val + " ");
    }
}