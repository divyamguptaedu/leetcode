"""
Performance: 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
Memory Usage: 38.2 MB, less than 90.90% of Java online submissions for Remove Duplicates from Sorted List II.
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previous = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                previous.next = head.next;
            } 
            else {
                previous = previous.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}