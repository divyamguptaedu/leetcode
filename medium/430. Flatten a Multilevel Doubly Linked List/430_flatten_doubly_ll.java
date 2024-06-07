//I used a stack to help with depth-first traversal of the multilevel linked list. 
//Starting from the head, I pushed nodes onto the stack as I traversed. 
//If a node had a child, I pushed the child and the next node onto the stack. 
//I linked the current node with the previous node and nullified the child pointer. 
//After processing all nodes, I detached the pseudo-head to return the flattened list.

//Time: n
//Space: n
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        // Create a pseudo head to handle edge cases easily
        Node pseudoHead = new Node(0, null, head, null);
        Node current, previous = pseudoHead;

        // Use a stack to manage depth-first traversal
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            current = stack.pop();
            // Link the current node with the previous node
            previous.next = current;
            current.prev = previous;

            // If the current node has a next node, push it onto the stack
            if (current.next != null) {
                stack.push(current.next);
            }
            // If the current node has a child node, push it onto the stack and nullify the
            // child pointer
            if (current.child != null) {
                stack.push(current.child);
                current.child = null;
            }
            // Move the previous pointer to the current node
            previous = current;
        }

        // Detach the pseudo head from the resulting list
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
}