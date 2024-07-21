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

// class Solution {
//     public Node connect(Node root) {
//         if (root == null) {
//             return null;
//         }
//         Queue<Node> queue = new LinkedList<>();
//         Node node = root;
//         queue.add(node);
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 Node currNode = queue.poll();
//                 if (i + 1 < size) {
//                     currNode.next = queue.peek();
//                 }
//                 if (currNode.left != null) {
//                     queue.add(currNode.left);
//                 }
//                 if (currNode.right != null) {
//                     queue.add(currNode.right);
//                 }
//             }
//         }
//         return root;
//     }
// }

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}