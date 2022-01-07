"
Performance:
Runtime: 18 ms, faster than 26.33% of Java online submissions for Linked List Random Node.
Memory Usage: 47.5 MB, less than 11.01% of Java online submissions for Linked List Random Node.
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
    
    int size = 1;
    ListNode head;
    ListNode current;

    public Solution(ListNode head) {
        this.head = head;
        current = head;
        while (current != null){
            current = current.next;
            size++;
        }
    }
    
    public int getRandom() {
        int x = 1;
        int random = (int) (Math.random() * (size - 1) + 1);
        current = head;
        while(x < random){
            current = current.next;
            x++;
        }
        return current.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */