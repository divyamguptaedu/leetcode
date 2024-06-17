//I reversed the linked list to traverse from the end to the start. 
//While traversing, I kept track of the maximum value encountered. 
//If the current node's value was less than the maximum, 
//I removed it by updating the previous node's next pointer. 
//If the current node's value was greater than or equal to the maximum, 
//I updated the maximum and moved to the next node. 
//After processing all nodes, 
//I reversed the list back to its original order and returned the modified list.

//Time: n
//Space: constant
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
    public ListNode removeNodes(ListNode head) {
        // Reverse the original linked list
        head = reverseList(head);

        int maximum = 0;
        ListNode prev = null;
        ListNode current = head;

        // Traverse the list deleting nodes
        while (current != null) {
            maximum = Math.max(maximum, current.val);

            // Delete nodes that are smaller than maximum
            if (current.val < maximum) {
                // Delete current by skipping
                prev.next = current.next;
                ListNode deleted = current;
                current = current.next;
                deleted.next = null;
            }

            // Current does not need to be deleted
            else {
                prev = current;
                current = current.next;
            }
        }
        
        // Reverse and return the modified linked list
        return reverseList(head);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode nextTemp = null;

        // Set each node's next pointer to the previous node
        while (current != null) {
            nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        return prev;
    }
}