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

 //Initially, I set up two pointers, prev and curr, initialized to null and head respectively. 
 //Using a while loop, I iterated through the list. 
 //Inside the loop, I maintained a temporary pointer nextTemp to store the next node of curr. 
 //I reversed the curr node's pointer to point to prev, then moved prev and curr pointers one step forward in the list. 
 //Finally, I returned prev as it now points to the new head of the reversed list. 
 
 //Time: n
 //Space: constant

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}