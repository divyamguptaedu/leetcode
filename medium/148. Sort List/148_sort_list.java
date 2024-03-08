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
        // use merge sort;
        ListNode middle = getMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return merge(left, right);
    }


    // merge two nodes after comparison;
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

    // helper method to find middle for merge sort;
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

//another solution

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
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    
    ListNode mid = findMiddle(head);
    ListNode midNext = mid.next;
    mid.next = null;
    
    ListNode sortedLeft = sortList(head);
    ListNode sortedRight = sortList(midNext);
    
    return merge(sortedLeft, sortedRight);
}

private ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

private ListNode merge(ListNode a, ListNode b) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    
    while (a != null && b != null) {
        if (a.val < b.val) {
            current.next = a;
            a = a.next;
        } else {
            current.next = b;
            b = b.next;
        }
        current = current.next;
    }
    
    current.next = (a != null) ? a : b;
    
    return dummy.next;
}
