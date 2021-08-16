"""
Performance:
Runtime: 4 ms, faster than 79.92% of Java online submissions for Merge k Sorted Lists.
Memory Usage: 40.5 MB, less than 67.72% of Java online submissions for Merge k Sorted Lists.
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
    public ListNode mergeKLists(ListNode[] lists) {
        // create a priority queue and add all nodes of each LL;
        PriorityQueue<ListNode> queue = new PriorityQueue((a, b) -> (a.val - b.val));
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (ListNode node : lists) {
        	if (node != null) {
        		queue.offer(node);
        	}
        }


        // remove one by one and add to a new LL;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
            	queue.offer(tail.next);
            }
        }
        return head.next;
    }
}