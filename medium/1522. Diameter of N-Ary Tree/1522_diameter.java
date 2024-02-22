/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    int diameter = 0;

    public int diameter(Node root) {
        helper(root);
        return diameter;
    }
    
    private int helper(Node root) {
        if (root == null) {
            return 0;
        }

        int tempOne = 0;
        int tempTwo = 0;  
           
        for (Node c : root.children) {
            int n = helper(c);
            if (n > tempOne) {
                tempTwo = tempOne;
                tempOne = n;   
            } else if (n > tempTwo) {
                tempTwo = n;
            }
        }
        
        diameter = Math.max(diameter, tempOne + tempTwo);
        
        return 1 + tempOne;
    }
}