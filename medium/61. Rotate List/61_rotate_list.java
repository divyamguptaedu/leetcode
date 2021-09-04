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

 /*
 1. Go till the tail.
 2. Set it as the head.
 3. Go till length - left out k.
 4. Return that node.
 
 Note: Edge case: When head is null.
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null) {
            return null;
        }
        
        int length = 1;
        ListNode tail = head;
        
        while (tail.next != null) {
            tail = tail.next;
            length = length + 1;
        }
        tail.next = head;
        
        for (int i = length - k % length; i > 0; i--) {
            tail = tail.next;
        }
        
        ListNode result = tail.next;
        tail.next = null;
        return result;
    }
}