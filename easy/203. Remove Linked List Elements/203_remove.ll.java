//
// Runtime: 1 ms, faster than 82.20% of Java online submissions for Remove Linked List Elements.
// Memory Usage: 39.6 MB, less than 89.45% of Java online submissions for Remove Linked List Elements.

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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return head;
            }
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        while (temp2 != null) {
            if (temp2.val == val) {
      
                temp2 = temp2.next;
                temp1.next = temp2;
            } else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

        }
        
        return head;
    }
}