"""
Performance:
Runtime: 10 ms, faster than 69.11% of Java online submissions for Serialize and Deserialize Binary Tree.
Memory Usage: 40.6 MB, less than 82.28% of Java online submissions for Serialize and Deserialize Binary Tree.
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder string = new StringBuilder();
        serializeHelper(root, string);
        String result = string.toString();
        return result;
    }

    private void serializeHelper(TreeNode root, StringBuilder string) {
    	if (root == null) {
    		string.append("*" + " ");
    		return;
    	}
    	string.append(root.val + " ");
    	serializeHelper(root.left, string);
    	serializeHelper(root.right, string);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(" ");
        int[] index = new int[1];
        TreeNode root = deserializeHelper(array, index);
        return root;
    }

    private TreeNode deserializeHelper(String[] array, int[] index) {
    	if (index[0] > array.length || array[index[0]].equals("*")) {
    		index[0]++;
    		return null;
    	}
    	int i = index[0]++;
    	int nodeValue = Integer.parseInt(array[i]);
    	TreeNode root = new TreeNode(nodeValue);
    	root.left = deserializeHelper(array, index);
    	root.right = deserializeHelper(array, index);
    	return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// another way

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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.append("n ");
                continue;
            }
            result.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            i++;
            if (!values[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


