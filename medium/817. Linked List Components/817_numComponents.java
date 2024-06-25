//First, I stored the subset elements in a HashSet for quick lookup. 
//Then, I traversed the linked list, counting segments where the elements are 
//part of the subset and consecutive. 
//I incremented the component count each time a sequence ended and reset the counter. 
//At the end, if a sequence was still ongoing, I included it in the count.
//Time: n where n is the num nodes in ll
//Space: m where m is num elements in subset array nums

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
    public int numComponents(ListNode head, int[] nums) {
        // Store subset elements in a set for quick lookup
        HashSet<Integer> subsetSet = new HashSet<>();
        for (int num : nums) {
            subsetSet.add(num);
        }
        
        int componentCount = 0;
        int currentSequence = 0;
        ListNode currentNode = head;

        while (currentNode != null) {
            // Check if current node's value is in the subset
            if (subsetSet.contains(currentNode.val)) {
                currentSequence++;
            } else if (currentSequence > 0) {
                // End of a connected component
                componentCount++;
                currentSequence = 0;
            }
            currentNode = currentNode.next;
        }
        
        // Check for an ongoing sequence at the end of the list
        if (currentSequence == 0) {
            return componentCount;
        }
        return componentCount + 1;
    }
}