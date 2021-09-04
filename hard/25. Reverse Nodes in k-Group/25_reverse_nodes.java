/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
1. Get to the first kth node.
2. Reverse the group.
    - reverse ll
3. Recurse.

Note: edge case - when you hit null and count is still not equal to k, then stop.
*/
class Solution {
            
    public ListNode reverseKGroup(ListNode head, int k) {  
        int count = 0;
        ListNode pointer = head;
        while (count < k && pointer != null) {
            pointer = pointer.next;
            count++;
        }
        if (count == k) {
            ListNode reversedHead = this.helper(head, k);
            head.next = this.reverseKGroup(pointer, k);
            return reversedHead;
        } else {
            return head;
        }
    }
    
    public ListNode helper(ListNode head, int k) {
        ListNode temp = null;
        ListNode pointer = head;
        while (k > 0) {
            ListNode next = pointer.next;
            pointer.next = temp;
            temp = pointer;
            pointer = next;
            k--;
        }
        return temp;
    }
}