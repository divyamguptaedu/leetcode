"""
Performance:
Runtime: 13 ms, faster than 28.77% of Java online submissions for Serialize and Deserialize N-ary Tree.
Memory Usage: 40.7 MB, less than 67.55% of Java online submissions for Serialize and Deserialize N-ary Tree.
"""

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

class Codec {

    public String serialize(Node root) {
        if(root == null) {
            return "";
        }
        Queue<Node> queue = new LinkedList<>();
        Node end = new Node(), child = new Node();
        queue.add(root); 
        queue.add(end);
        StringBuilder stringBuilder = new StringBuilder();
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node == end){
                stringBuilder.append("/");
                if(!queue.isEmpty())
                    queue.add(end);
            }
            else if(node == child){
                stringBuilder.append("*");
            }else {
                stringBuilder.append(node.val + ",");
                for(Node c : node.children)
                    queue.add(c);
                if(queue.peek()!= end)
                    queue.add(child);
            }
        }
        return stringBuilder.toString();
    }
    
    public Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        int start = data.indexOf(",");
        Node root = new Node(Integer.parseInt(data.substring(0, start)), new ArrayList<Node>());
        helper (root, data, start);
        return root;
    }

    public void helper(Node root, String s,int start){
        LinkedList<Node> llOne = new LinkedList<Node>(), llTwo = new LinkedList<Node>();
        llOne.add(root);
        llTwo.add(root);
        Node rootNode = root;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ',') {
                continue;
            }
            if (c == '/') {
                llTwo = llOne;
                llOne = new LinkedList();
                rootNode = llTwo.poll();
            } else {
                if(c == '*')
                    rootNode = llTwo.poll();
                else{
                    int j = i+1;
                    while (j<s.length() && s.charAt(j) != ',') {
                        j++;
                    }
                    Node child = new Node(Integer.parseInt(s.substring(i, j)), new ArrayList());
                    i = j;
                llOne.add(child);
                rootNode.children.add(child);
                }
            }
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));