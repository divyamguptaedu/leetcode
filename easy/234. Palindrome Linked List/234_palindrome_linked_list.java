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