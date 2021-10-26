"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
Memory Usage: 42.4 MB, less than 47.66% of Java online submissions for Reverse Nodes in k-Group.
"

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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = k;
        ListNode headNode = head;
        while (headNode != null && count > 0) {
            headNode = headNode.next;
            count--;
        }
        if (count>0) {
            return head;
        }
        
        ListNode previous = reverseKGroup(headNode, k);
        headNode = head;
        for (int i = 0; i < k; i++) {
            ListNode next = headNode.next;
            headNode.next = previous;
            previous = headNode;
            headNode = next;
        }
        return previous;
    }
}