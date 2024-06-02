//I first checked if the list was empty. If it was, I created a new node that pointed to itself and returned it. 
//Otherwise, I started from the given node and traversed the list.
//During the traversal, I compared the current node's value and the next node's value to 
//find the correct spot for insertion. I handled three cases: inserting between two nodes, 
//inserting at the end of the list when the list had wrapped around, and if no suitable spot was 
//found during traversal or if all numbers are uniform, then inserting at the end by default.

//Time: O(n)
//Space: O(1)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {  // If the list is empty, create a new node that points to itself
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;  // Initialize prev to the given node
        Node curr = head.next;  // Initialize curr to the next node
        boolean toInsert = false;

        do {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                // Case 1: Insert between two nodes
                toInsert = true;
            } else if (prev.val > curr.val) {
                // Case 2: Insert at the end of the list when it wraps around
                if (insertVal >= prev.val || insertVal <= curr.val)
                    toInsert = true;
            }

            if (toInsert) {  // If the correct spot is found, insert the new node
                prev.next = new Node(insertVal, curr);
                return head;
            }

            prev = curr;  // Move to the next node
            curr = curr.next;
        } while (prev != head);  // Continue until we circle back to the start

        // Case 3: If no suitable spot was found, insert at the end by default
        prev.next = new Node(insertVal, curr);
        return head;
    }
}