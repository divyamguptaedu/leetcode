/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode result = add(l1, l2);
        return reverseList(result);
    }

    private ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
    
    private ListNode add(ListNode l1, ListNode l2) {
        int tempSum = 0;
        ListNode result = new ListNode();
        ListNode current = result;
        while (l1 != null || l2 != null || tempSum != 0) {
            if (l1 != null) {
                tempSum = tempSum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tempSum = tempSum + l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(tempSum % 10);
            // carry over
            tempSum = tempSum / 10;
            current = current.next;
        }
        return result.next;
    }
}