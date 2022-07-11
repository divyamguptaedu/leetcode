"
Performance:
Runtime: 15 ms, faster than 82.90% of Java online submissions for Linked List Components.
Memory Usage: 54 MB, less than 60.90% of Java online submissions for Linked List Components.
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
    public int numComponents(ListNode head, int[] nums) {
        Map<Integer,Integer> valueMap = new HashMap<>();
        for (int i:nums) {
            valueMap.put(i,0);
        }
        boolean color = false;
        int count = 0;
        if (valueMap.containsKey(head.val)) { 
            color = true;
        }
        while (head != null) {
            if (valueMap.containsKey(head.val)) {
                if (color) {
                    count++;
                }
                color = false;
            } else {
                color = true;
            }
            head = head.next;
        }
        return count;
    }
}