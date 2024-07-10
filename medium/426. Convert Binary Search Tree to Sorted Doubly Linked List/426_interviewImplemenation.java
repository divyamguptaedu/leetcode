// Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
// You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
// We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.

class Solution {
    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        
        // Step 1: Convert BST to sorted list
        List<Node> sorted = new ArrayList<>();
        treeToList(root, sorted);
        
        // Step 2: Convert sorted list to circular doubly linked list
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

    // In-order traversal to populate sorted list
    private void treeToList(Node root, List<Node> sorted) {
        if (root == null)
            return;
        
        treeToList(root.left, sorted);
        sorted.add(root);
        treeToList(root.right, sorted);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage and testing
        // Create a sample BST
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        // Convert BST to CDLL
        Node head = solution.treeToDoublyList(root);

        // Print the circular doubly linked list
        System.out.println("Circular Doubly Linked List:");
        Node current = head;
        do {
            System.out.print(current.val + " ");
            current = current.right;
        } while (current != head);
        System.out.println();
    }
}
