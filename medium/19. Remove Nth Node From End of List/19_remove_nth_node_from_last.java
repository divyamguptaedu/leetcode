//I used a two-pointer technique to remove the nth node from the end of a linked list. 
//I created a dummy node to handle edge cases where the head needs to be removed. 
//I positioned the first pointer n+1 nodes ahead of the second pointer, 
//then moved both pointers until the first reached the end of the list. 
//This positioned the second pointer just before the node to be removed. 
//Finally, I adjusted the pointers to skip the target node.

//Time: O(n)
//Space: O(1)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize two pointers, first and second, at the dummy node
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move the first pointer so there is a gap of n nodes between first and second
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches the end of the list
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Skip the nth node from the end
        second.next = second.next.next;
        
        // Return the head of the modified list
        return dummy.next;
    }
}