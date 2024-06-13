//To find the intersection of two linked lists, I used a two-pointer approach. 
//I initialized two pointers at the heads of the two lists and traversed through them. 
//When each pointer reached the end of a list, 
//I redirected it to the head of the other list. 
//If the lists intersect, the pointers eventually met at the intersection node. 
//If they didn’t intersect, both pointers reached the end (null) simultaneously. 
//This approach ensured that both pointers traveled the same total distance, 
//thus meeting at the intersection or end at the same time.

//Time: n+m
//Space: constant

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Initialize two pointers to traverse the lists
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse the lists until the pointers meet
        while (pointerA != pointerB) {
            // Move pointerA to the head of listB if it reaches the end of listA, otherwise move to the next node
            pointerA = (pointerA == null) ? headB : pointerA.next;
            // Move pointerB to the head of listA if it reaches the end of listB, otherwise move to the next node
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Return the intersection node or null if there is no intersection
        return pointerA;
        // Note: In the case lists do not intersect, the pointers for A and B
        // will still line up in the 2nd iteration, just that here won't be
        // a common node down the list and both will reach their respective ends
        // at the same time. So pA will be NULL in that case.
    }
}
