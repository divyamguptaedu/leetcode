//My approach starts by finding the end of the first half of the linked list and
//then reverses the second half. 
//After that, I iterate through both halves, comparing the values of corresponding nodes.
//If any values don't match, I set the result to false. 

//Ask the interviewer if we need to restore the list back?

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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        // Find the end of the first half and reverse the second half.
        ListNode firstHalfEnd = findEndOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check for palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }        

        //in case we need to restore the list
        //firstHalfEnd.next = reverseList(secondHalfStart);

        return result;
    }

    // Function to reverse a linked list.
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    // Function to find the end of the first half of the linked list.
    private ListNode findEndOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
