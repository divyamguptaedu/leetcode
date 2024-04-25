//Used DFS and created a deep copy of every node using recursion.
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
//Time: O(v+e)
//Space: O(v)
class Solution {
    private HashMap <Node, Node> visited = new HashMap <> ();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        if (visited.containsKey(node)) { //we want to return the cloned node, not the original node
            return visited.get(node);
        }

        Node deepCopyNode = new Node(node.val, new ArrayList()); //create a clone and add it to the visited map
        visited.put(node, deepCopyNode);

        for (Node neighbor: node.neighbors) { //clone the neighbors as well, use recursion
            deepCopyNode.neighbors.add(cloneGraph(neighbor));
        }
        return deepCopyNode;
    }
}