"""
Performance:
Runtime: 2 ms, faster than 59.31% of Java online submissions for Add Two Numbers.
Memory Usage: 39.4 MB, less than 50.53% of Java online submissions for Add Two Numbers.
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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

	    int carryOver = 0;
	    ListNode temp = new ListNode(0);
	   	ListNode result = new ListNode(0);
	    temp = result;

	    // added and carrie over the remainder;
	    while (l1 != null || l2 != null || carryOver != 0) {

	        if (l1 != null) {
	            carryOver += l1.val;
	            l1 = l1.next;
	        }
	        if (l2 != null) {
	            carryOver += l2.val;
	            l2 = l2.next;
	        }

	        temp.next = new ListNode(carry % 10);
	        carry = carry / 10;
	        temp = temp.next;
	        
	    }

	    return result.next;
	}
}