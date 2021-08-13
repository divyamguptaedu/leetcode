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
         ListNode temp = new ListNode(101);
         temp.next = head;
         ListNode pointerA = temp;
         ListNode pointerB = temp;
         for (int i = 0; i < n; i++) {
         	pointerB = pointerB.next;
         }
         while (pointerB.next != null) {
         	pointerA = pointerA.next;
         	pointerB = pointerB.next;
         }
         pointerA.next = pointerA.next.next;
         return temp.next;
    }
}