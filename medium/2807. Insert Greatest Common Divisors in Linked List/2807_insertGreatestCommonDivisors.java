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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            if (previous != null && current != null) {
                int gcdValue = calculateGcd(previous.val, current.val);
                ListNode newNode = new ListNode(gcdValue, current);
                previous.next = newNode;
            }
            previous = current;
            current = current.next;
        }   
        return head;
    }

    private int calculateGcd(int value1, int value2) {

        if (value2 == 0) {
            return value1;
        }
        return calculateGcd(value2, value1 % value2);
    }
}
