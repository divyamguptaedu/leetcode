//Used stringbuilder and recursive DFS to have all nodes and their children seperated by the 
//size of the list of children. 
//All nodes seperated by a comma to be able to split add nodes and decode.
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
//Time: O(n)
//Space: O(n)
class Codec {
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        helperSerialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public void helperSerialize(Node curr, StringBuilder sb) {
        if (curr == null) {
            return;
        }
        sb.append(curr.val + ",");
        sb.append(curr.children.size() + ",");
        for (Node child: curr.children) {
            helperSerialize(child, sb);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] stringArrayOfNodes = data.split(",");
        return helperDeserialize(stringArrayOfNodes);
    }
    
    public Node helperDeserialize(String[] input) {
        if (index >= input.length) {
            return null;
        }
        int value = Integer.valueOf(input[index++]);
        int size = Integer.valueOf(input[index++]);
        Node currentNode = new Node(value, new ArrayList<>());
        for (int i = 0; i < size; i++) {
            currentNode.children.add(helperDeserialize(input));
        }
        return currentNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));