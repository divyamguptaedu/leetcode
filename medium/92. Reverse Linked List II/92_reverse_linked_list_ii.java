//I iterated through the linked list until reaching the left and right positions to be
//reversed, keeping track of the nodes before and after the sublist to be reversed.
//Then, I reversed the sublist iteratively by adjusting the next pointers.
//Finally, I adjusted the connections of the adjacent nodes to integrate the reversed
//sublist into the overall list structure.
//If the sublist starts from the beginning of the list, I updated the head node.
//This approach modifies the list in place without requiring extra space.

//Time: n
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null; // Return null if the list is empty
        }

        ListNode current = head;
        ListNode previous = null;
        // Move pointers to the starting position of the sublist to be reversed
        while (left > 1) {
            previous = current;
            current = current.next;
            left--;
            right--;
        }

        ListNode connection = previous;
        ListNode tail = current;
        ListNode nextNode = null;
        // Reverse the sublist
        while (right > 0) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
            right--;
        }

        // Adjust connections
        if (connection != null) {
            connection.next = previous;
        } else {
            head = previous; // If sublist starts from the beginning, update head
        }

        tail.next = current;
        return head;
    }
}