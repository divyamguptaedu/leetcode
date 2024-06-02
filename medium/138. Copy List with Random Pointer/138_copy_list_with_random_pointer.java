//I first created a new interleaved list by inserting cloned nodes next to their original counterparts. 
//This way, each original node was followed by its clone. 
//Then, I assigned the random pointers for the cloned nodes by using the random pointers of the 
//original nodes. Finally, I separated the original and cloned nodes to form two separate lists, 
//restoring the original list and forming the deep copy.

//Time: O(n)
//Space: O(1)

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val) {
        val = _val;
        next = null;
        random = null;
    }
}
*/
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;  // Return null if the original list is empty
        }

        // Step 1: Create a new interleaved list with cloned nodes
        Node ptr = head;
        while (ptr != null) {
            Node newNode = new Node(ptr.val);  // Create a cloned node
            newNode.next = ptr.next;  // Set the next of cloned node
            ptr.next = newNode;  // Insert cloned node next to original node
            ptr = newNode.next;  // Move to the next original node
        }

        ptr = head;
        // Step 2: Set the random pointers for the cloned nodes
        while (ptr != null) {
            if (ptr.random != null) {
                ptr.next.random = ptr.random.next;  // Set random pointer of cloned node
            }
            ptr = ptr.next.next;  // Move to the next original node
        }

        // Step 3: Separate the interleaved list into original and cloned lists
        Node ptr_old_list = head;  // Pointer to the original list
        Node ptr_new_list = head.next;  // Pointer to the new list
        Node head_old = head.next;  // Head of the new list

        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;  // Restore original list
            if (ptr_new_list.next != null) {
                ptr_new_list.next = ptr_new_list.next.next;  // Set next for cloned list
            }
            ptr_old_list = ptr_old_list.next;  // Move to the next original node
            ptr_new_list = ptr_new_list.next;  // Move to the next cloned node
        }

        return head_old;  // Return the head of the deep copied list
    }
}