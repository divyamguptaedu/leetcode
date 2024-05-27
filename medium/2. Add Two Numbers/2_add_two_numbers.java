//I traverse both linked lists simultaneously, summing the digits at corresponding positions and accounting for any carry. 
//I use a dummy head to facilitate linked list construction. 
//At each step, I calculate the sum of digits along with the carry from the previous step. 
//Then, I update the current node with the remainder of the sum, and move to the next node. 
//If either linked list ends or there's still a carry, I continue the process. 
//Finally, I return the next node of the dummy head, which contains the result. 
//This solution processes both linked lists once, maintaining constant space complexity.

//Time: O(max(m,n))
//Space: O(max(m,n))

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head to facilitate linked list construction
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        // Iterate through both linked lists until both end and no carry left
        while (l1 != null || l2 != null || carry != 0) {
            // Get the current digit from each linked list
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            // Calculate the sum of digits and carry
            int sum = carry + x + y;
            carry = sum / 10; // Update carry
            // Create a new node with the remainder of the sum
            curr.next = new ListNode(sum % 10);
            curr = curr.next; // Move to the next node
            // Move to the next nodes in both linked lists if they are not null
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next; // Return the next node of the dummy head
    }
}