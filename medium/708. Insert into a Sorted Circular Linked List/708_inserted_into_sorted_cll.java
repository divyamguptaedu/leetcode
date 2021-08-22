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
            
            if (head == null) {
                Node temp = new Node(insertVal);
                temp.next=temp;
                return temp;
            }
            
            Node h = head;
            boolean isInserted = false;
            
            while(!isInserted) {
                Node temp = new Node(insertVal);
                if ((head.val <= insertVal && head.next.val >= insertVal) ||
                    (head.val >= insertVal && head.next.val >= insertVal && head.next.val < head.val) ||
                    (head.val <= insertVal && head.next.val <= insertVal && head.next.val < head.val)) {
                    Node next = head.next;
                    head.next = temp;
                    temp.next = next;  
                    isInserted = true;
                }
                
                Node = head;
                head = head.next;
                
                if (head == h) {
                    p.next = temp;
                    temp.next = head;
                    isInserted = true;
                }
              
            }
            return h;
        }
}