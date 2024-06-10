//I merged two sorted linked lists by iterating through both lists and comparing their nodes. 
//I created a dummy node to simplify edge cases and used a pointer to build the merged list. 
//By comparing the values of nodes from both lists, 
//I linked the smaller node to the merged list and advanced the pointer. 
//Once one of the lists was exhausted, I connected the remaining nodes from the other 
//list to the merged list. Finally, I returned the merged list starting from the node 
//after the dummy node.

//Time: n+m
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node to serve as the start of the merged list
        ListNode prehead = new ListNode(-1);

        // Pointer to build the new list
        ListNode current = prehead;

        // While neither list is empty, compare the nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // If list1's node is smaller or equal, append it to the merged list
                current.next = list1;
                list1 = list1.next; // Move to the next node in list1
            } else {
                // If list2's node is smaller, append it to the merged list
                current.next = list2;
                list2 = list2.next; // Move to the next node in list2
            }
            current = current.next; // Move to the next node in the merged list
        }

        // At least one of the lists is now empty, so append the remaining nodes from the non-empty list
        current.next = (list1 == null) ? list2 : list1;

        // The merged list is next to the dummy node
        return prehead.next;
    }
}