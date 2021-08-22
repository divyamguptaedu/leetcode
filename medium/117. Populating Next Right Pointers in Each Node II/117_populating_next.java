/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode firstNode = new TreeLinkNode(0); //Dummy head
            TreeLinkNode pre = firstNode;
            for (TreeLinkNode cur = root; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = cur.left;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = cur.right;
                }
            }
            root = firstNode.next;
        }
    }
}