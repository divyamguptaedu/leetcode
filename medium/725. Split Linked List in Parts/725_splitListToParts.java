"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Split Linked List in Parts.
Memory Usage: 44 MB, less than 50.07% of Java online submissions for Split Linked List in Parts.
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        if (k == 1) {
            result[0] = head;
        } else {
            int temp = helper(head);
            ListNode previous = null;
            for (int i = 0; i < k; i++) {
                result[i] = head;
                int j = temp / k + (i < (temp % k) ? 1 : 0);
                while (head != null && j > 0) {
                    previous = head;
                    head = head.next;
                    j--;
                }
                if (previous != null) {
                    previous.next = null;
                }   
            }
        }
        return result;
    }

    public int helper(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}