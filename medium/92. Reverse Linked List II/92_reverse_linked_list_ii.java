"""
Performance: 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
Memory Usage: 36.6 MB, less than 73.22% of Java online submissions for Reverse Linked List II.

"""

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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right <= 1 || left < 1) {
            return head;
        }
        int count = 1;
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;
        ListNode start = head;
        ListNode end = null;
        ListNode temp = head;
        while (head != null) {
            if (count == left) {
                start = head;
            }
            if (count == right + 1) {
                end = head.next;
                head.next = null;
            }
            count++;
            head = head.next;
        }
        if (start != null) {

            ListNode previous = start.next;
            start.next = reverse(start.next);
            previous.next = end;
        }
        return temp.next;
    }
    
     private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = head.next;
        ListNode next = reverse(head.next);
        previous.next = head;
        head.next = null;
        return next;
    }
}
