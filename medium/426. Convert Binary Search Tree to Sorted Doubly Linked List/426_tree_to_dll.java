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
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        List<Node> sorted = new ArrayList<>();
        inorderTraversal(root, sorted);

        int len = sorted.size();
        Node head = sorted.get(0);
        Node tail = sorted.get(len - 1);

        for (int i = 0; i < len; i++) {
            Node curr = sorted.get(i);
            curr.left = i == 0 ? tail : sorted.get(i - 1);
            curr.right = i == len - 1 ? head : sorted.get(i + 1);
        }

        return head;
    }

    private void inorderTraversal(Node root, List<Node> sorted) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, sorted);
        sorted.add(root);
        inorderTraversal(root.right, sorted);
    }
}
