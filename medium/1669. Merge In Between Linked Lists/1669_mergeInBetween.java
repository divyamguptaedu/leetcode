//I traversed list1 to find the node before the ath node and the bth node. 
//Then, I connected the ath-1 node to list2 and traversed list2 to find its tail. 
//Finally, I linked the tail of list2 to the node after the bth node in list1, 
//effectively merging list2 between the ath and bth nodes of list1.

//Time: n+m
//Space: constant
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int startRange, int endRange, ListNode list2) {
        ListNode beforeStart = null;
        ListNode afterEnd = list1;

        // Traverse to the node before the start of the range
        for (int index = 0; index < endRange; index++) {
            if (index == startRange - 1) {
                beforeStart = afterEnd;
            }
            afterEnd = afterEnd.next;
        }
        // Connect the node before the start of the range to the head of list2
        beforeStart.next = list2;

        // Traverse to the end of list2 to find its tail
        while (list2.next != null) {
            list2 = list2.next;
        }
        // Connect the tail of list2 to the node after the end of the range
        list2.next = afterEnd.next;
        // Disconnect the end of the range from the rest of the list
        afterEnd.next = null;

        return list1;
    }
}