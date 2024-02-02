"""
Performance:
Runtime: 6 ms, faster than 64.70% of Java online submissions for Palindrome Linked List.
Memory Usage: 51.3 MB, less than 52.00% of Java online submissions for Palindrome Linked List.
"""

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
    public boolean isPalindrome(ListNode head) {
        // convert to array
        ArrayList<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }

        // use pointers to check the pattern
        int size = array.size();
        int i = 0;
        int j = size - 1;
        while (i <= j) {
            if (array.get(i) != array.get(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}

//another solution

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
    public boolean isPalindrome(ListNode head) {
        ListNode middle = head;
        ListNode end = head;
        while (end != null && end.next != null) {
            middle = middle.next;
            end = end.next.next;
        } 
        ListNode temp = reverseList(middle);
        while (temp != null && head != null) {
            if (temp.val != head.val) {
                return false;
            }
            temp = temp.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {        
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}

