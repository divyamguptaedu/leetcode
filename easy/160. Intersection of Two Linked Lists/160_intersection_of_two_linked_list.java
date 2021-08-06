"""
Performance:
Runtime: 7 ms, faster than 26.08% of Java online submissions for Intersection of Two Linked Lists.
Memory Usage: 42.6 MB, less than 28.98% of Java online submissions for Intersection of Two Linked Lists.
"""
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> valueMap = new HashMap<>();
        int value;
        while (headA != null) {
            valueMap.put(headA, 1);
            headA = headA.next;
        }
        while (headB != null) {
            if (valueMap.get(headB) != null) {
                value = valueMap.get(headB);
                if (value == 1) {
                    return headB;
                }
            }
            headB = headB.next;
        }
        return null;
    }
}