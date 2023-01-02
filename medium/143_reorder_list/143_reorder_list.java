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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        curr = head;
        int size = stack.size() / 2;

        while (size-- > 0) {
            ListNode top = stack.pop();
            ListNode temp = curr.next;
            curr.next = top;
            curr = temp;
            top.next = temp;
        }

        curr.next = null;
    }
}
