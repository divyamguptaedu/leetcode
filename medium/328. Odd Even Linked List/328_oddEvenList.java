//I used two pointers, odd and even, to track the current odd and even nodes, 
//and another pointer, evenHead, to store the head of the even-indexed nodes. 
//Starting from the head, I connected odd-indexed nodes to the next odd-indexed 
//nodes and even-indexed nodes to the next even-indexed nodes. 
//After processing all nodes, I linked the last odd-indexed node to the head of the 
//even-indexed nodes. This maintained the relative order of nodes within the odd and even groups.

//Time: n
//Space: constant

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        // Initialize pointers for odd and even nodes
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // Reorder nodes by alternating odd and even
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        // Connect the last odd node to the head of even nodes
        odd.next = evenHead;
        
        return head;
    }
}