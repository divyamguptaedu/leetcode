"""
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
Memory Usage: 42.5 MB, less than 6.04% of Java online submissions for Copy List with Random Pointer.
"""

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> valueMap = new HashMap<>();
        Node temp = head;
        // create new nodes and add to hashmap;
        while (temp != null) {
            valueMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        // track down the next and random;
        while (temp != null) {
            valueMap.get(temp).next = valueMap.get(temp.next);
            valueMap.get(temp).random = valueMap.get(temp.random);
            temp = temp.next;
        }
        return valueMap.get(head);
    }
}