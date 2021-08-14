"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
Memory Usage: 39.5 MB, less than 5.42% of Java online submissions for Remove Nth Node From End of List.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if (head == null) {
         	return null;
         }
         // add a temp node in the front;
         ListNode temp = new ListNode(101);
         temp.next = head;

         // have two pointers at this temp node;
         ListNode pointerA = temp;
         ListNode pointerB = temp;

         // move the second pointer n steps ahead;
         for (int i = 0; i < n; i++) {
         	pointerB = pointerB.next;
         }

         // move both pointers until the second one reaches the end;
         while (pointerB.next != null) {
         	pointerA = pointerA.next;
         	pointerB = pointerB.next;
         }
         // now the first pointer is just behind the one to be removed;
         pointerA.next = pointerA.next.next;
         return temp.next;
    }
}