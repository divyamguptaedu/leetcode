"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
Memory Usage: 39.7 MB, less than 6.92% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
"

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

class Solution {
    Node previous;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        previous = new Node();
        Node temp = previous;
        inOrderTraversal(root);
        previous.right = temp.right;
        temp.right.left = previous;
        return temp.right;
    }
    
    private void inOrderTraversal(Node root){
        if (root == null) {
            return;
        }
        //inorder
        inOrderTraversal(root.left);
        previous.right = root;
        root.left = previous;
        previous = root;
        inOrderTraversal(root.right);
    }
}