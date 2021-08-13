"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
Memory Usage: 39.3 MB, less than 32.42% of Java online submissions for Linked List Cycle II.
"""

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                while (head != null) { 
                    if (head == fast) {
                        return head;
                    }
                    head = head.next;
                    fast = fast.next;
                }
            }
        }
        return null;
    }
}