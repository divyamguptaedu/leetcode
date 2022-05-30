"""
Performance:
Runtime: 4 ms, faster than 59.94% of Java online submissions for Add Two Numbers II.
Memory Usage: 47.9 MB, less than 50.38% of Java online submissions for Add Two Numbers II.
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
        ListNode tempOne =  helper(l1);
        ListNode tempTwo =  helper(l2);
        ListNode temp = new ListNode(0);
        ListNode tail = temp;
        int over = 0;
        while(tempOne!=null || tempTwo!=null) {
            int x = (tempOne!=null)?tempOne.val:0;
            int y = (tempTwo!=null)?tempTwo.val:0;
            
            int sum = over + x + y;
            over = sum/10;
            tail.next = new ListNode(sum%10);
            
            tail=  tail.next;
            
            if (tempOne != null) {
                tempOne = tempOne.next;
            }
            
            if (tempTwo != null) {
                tempTwo = tempTwo.next;
            }
        }
        
        if (over > 0) {
            tail.next = new ListNode(over);
        }
        return helper(temp.next);
    }
    
    public ListNode helper(ListNode head){
        ListNode next = null;
        ListNode prev = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
}