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
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        ListNode intersectNode = new ListNode(8);
        intersectNode.next = new ListNode(4);
        intersectNode.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersectNode;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersectNode;

        ListNode result = solution.getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection node value: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }

        // Example 2
        ListNode headA2 = new ListNode(2);
        headA2.next = new ListNode(6);
        headA2.next.next = new ListNode(4);

        ListNode headB2 = new ListNode(1);
        headB2.next = new ListNode(5);

        ListNode result2 = solution.getIntersectionNode(headA2, headB2);
        if (result2 != null) {
            System.out.println("Intersection node value: " + result2.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
