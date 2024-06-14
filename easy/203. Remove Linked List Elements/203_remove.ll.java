//To remove nodes from a linked list with a given value, 
//I created a dummy node to simplify edge cases where the head node needs removal. 
//I used two pointers, prev and curr, to traverse the list. 
//Prev tracked the last valid node, while curr checked each node. 
//If curr.val matched the target value, I bypassed it by setting prev.next to 
//curr.next. Otherwise, I moved prev to curr. 
//This way, I maintained a clean, updated linked list without the target values 
//and returned the list starting from dummy.next.

//Time: N
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val)
                prev.next = curr.next;
            else
                prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}