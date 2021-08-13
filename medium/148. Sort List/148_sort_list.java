"""
Performance:
Runtime: 13 ms, faster than 10.52% of Java online submissions for Sort List.
Memory Usage: 53.5 MB, less than 5.64% of Java online submissions for Sort List.
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return merge(left, right);
    }

    ListNode merge(ListNode one, ListNode two) {
        ListNode tempHead = new ListNode();
        ListNode tail = tempHead;
        while (one != null && two != null) {
            if (one.val < two.val) {
                tail.next = one;
                one = one.next;
                tail = tail.next;
            } else {
                tail.next = two;
                two = two.next;
                tail = tail.next;
            }
        }
        if (one != null) {
       		tail.next = one;
        } else {
        	tail.next = two;
        }
        return tempHead.next;
    }

    ListNode getMiddle(ListNode head) {
        ListNode previous = null;
        while (head != null && head.next != null) {
        	if (previous == null) {
        		previous = head;
        	} else {
        		previous = previous.next;
        	}
            head = head.next.next;
        }
        ListNode mid = previous.next;
        previous.next = null;
        return mid;
    }
}