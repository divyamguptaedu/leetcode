//To solve this question, we will just initialize a priority queue with a comparator which places the smaller
//element first. We will add all the nodes in the pq and will add their children as well if present.
//Then we one by one poll the pq and initialize the next creating a merged sorted list.

//Time: O(NlogK) where N is the total number of nodes in the final list, and k is the number of lists.
//Space: O(k) for the heap. Heap takes less space than N is most situations.

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
        ListNode head = new ListNode(0);
        ListNode point = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val > o2.val) {
                        return 1; //place o1 later
                    } else if (o1.val == o2.val) {
                        return 0; //order doesn't matter
                    } else {
                        return -1; //place o1 first
                    }
                }
            }
        );
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            if (point.next != null) {
                queue.add(point.next);
            }
        }
        return head.next;
    }
}