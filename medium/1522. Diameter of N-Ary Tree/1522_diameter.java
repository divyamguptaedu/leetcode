//Used DFS on the N-Ary tree,  calculated the height of the nodes, 
//and kept the maximumHeight and nextMaximumHeight updated. 
//Added them together to keep track of the maxDiameter.
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
//Time: O(n)
//Space: O(n)
class Solution {
    int diameter = 0;

    public int diameter(Node root) {
        this.diameter = 0;
        height(root);
        return diameter;
    }

    public int height(Node node) {
        if (node.children.size() == 0) {
            return 0;
        }

        int maximumHeight = 0;
        int nextMaximumHeight = 0;
        for (Node child : node.children) {
            int newHeight = height(child) + 1;
            if (newHeight > maximumHeight) {
                nextMaximumHeight = maximumHeight;
                maximumHeight = newHeight;
            } else if (newHeight > nextMaximumHeight) {
                nextMaximumHeight = newHeight;
            }
            int distance = maximumHeight + nextMaximumHeight;
            this.diameter = Math.max(this.diameter, distance);
        }

        return maximumHeight;
    }
}

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
        this.diameter = 0;
        height(root);
        return diameter;
    }

    private int height(Node node) {
        if (node.children.size() == 0) {
            return 0;
        }

        int maxHeight1 = 0;
        int maxHeight2 = 0;

        for (Node child : node.children) {
            int parentHeight = height(child) + 1;
            if (parentHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = parentHeight;
            } else if (parentHeight > maxHeight2) {
                maxHeight2 = parentHeight;
            }
            int distance = maxHeight1 + maxHeight2;
            this.diameter = Math.max(this.diameter, distance);
        }

        return maxHeight1;
    }
}