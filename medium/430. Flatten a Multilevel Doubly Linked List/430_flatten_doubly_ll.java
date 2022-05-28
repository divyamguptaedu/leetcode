"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten a Multilevel Doubly Linked List.
Memory Usage: 42.4 MB, less than 37.93% of Java online submissions for Flatten a Multilevel Doubly Linked List.
"""

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    Node result = new Node(0);
    Node tempResult = result;
    
    public Node flatten(Node head) {
        helper(head, null);
        return result.next;
    }
    
    public void helper(Node current, Node previous) {
        if (current == null){
            return;
        }
        tempResult.next = new Node(current.val);
        tempResult = tempResult.next;
        tempResult.prev = previous;
        
        
        if (current.child != null){
            helper(current.child, tempResult);
        }
        if (current.next != null){
            helper(current.next, tempResult);
        }
        
    }
}