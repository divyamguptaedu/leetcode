/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//I just copy over the value of the next node to the given node to be deleted. And then just set its next to the next node's next.
//So, I am just copying over the next node to the current node and skipping the next node.
//Time: constant
//Space: constant;
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}