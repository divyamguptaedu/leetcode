//I approached the problem by using a level-order traversal. 
//I used two pointers, prev and leftmost, to keep track of nodes on 
//the current and next levels. Starting from the root, I iterated through each level. 
//For each node, I updated its next pointer to the next right node. 
//If the node had children, I updated the prev pointer and set the leftmost pointer for the next level. 
//This ensured that all nodes' next pointers were correctly assigned.
//Time: n
//Space: constant
class Solution {
    private Node prev, leftmost;

    // Method to process child nodes
    public void processChild(Node childNode) {
        if (childNode != null) {
            // If "prev" is already set, link the current node's next to the child
            if (this.prev != null) {
                this.prev.next = childNode;
            } else {
                // If this is the first child node on the next level, set "leftmost"
                this.leftmost = childNode;
            }
            // Update "prev" to the current child node
            this.prev = childNode;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // Initialize the leftmost node of the first level
        this.leftmost = root;

        // Loop until there are no more levels
        while (this.leftmost != null) {
            this.prev = null; // Reset "prev" for the next level
            Node current = this.leftmost; // Start with the leftmost node of the current level

            // Reset "leftmost" for the next level
            this.leftmost = null;

            // Iterate over the current level
            while (current != null) {
                // Process the children of the current node
                processChild(current.left);
                processChild(current.right);

                // Move to the next node in the current level
                current = current.next;
            }
        }

        return root;
    }
}
