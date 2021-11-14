"""
Performance: 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
Memory Usage: 39.9 MB, less than 7.83% of Java online submissions for Partition List.
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
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode tempOne = smaller;
        ListNode greater = new ListNode(0);
        ListNode tempTwo = greater;
        while (head != null) {
            if (head.val < x) {
                tempOne.next = new ListNode(head.val);
                tempOne = tempOne.next;
            } else {
                tempTwo.next = new ListNode(head.val);
                tempTwo = tempTwo.next;
            }
            head = head.next;
        }
        tempOne.next = greater.next;
        return smaller.next;
    }
}