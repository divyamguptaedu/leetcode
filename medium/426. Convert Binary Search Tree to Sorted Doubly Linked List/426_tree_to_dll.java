/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

//Time: O(n)
//Space: O(n) for the recursion stack.

class Solution {
    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs_inorder(root);

        // link the last and first to make it circular.
        last.right = first;
        first.left = last;
        return first;
    }

    public void dfs_inorder(Node currentNode) {
        if (currentNode != null) {
            // left
            dfs_inorder(currentNode.left);

            // node 
            if (last != null) {
                //link the last and current together
                last.right = currentNode;
                currentNode.left = last;
            }
            else {
                first = currentNode; //initialize the first because it will be the smallest.
            }
            last = currentNode; //to be used by the next node for connection

            // right
            dfs_inorder(currentNode.right);
        }
    }
}