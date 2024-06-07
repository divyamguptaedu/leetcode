//I implemented an LRU cache using a hashmap to store key-node mappings and
//a doubly linked list to maintain the order of recently used nodes. 
//Each node in the linked list contains a key-value pair. 
//When accessing a key, I move its corresponding node to the end of the list
//to indicate it's the most recently used. 
//When adding a new key-value pair, I add it to the end of the list and remove
//the least recently used node if the capacity is exceeded.
//This approach ensures constant time complexity for both get and put operations.

//Time: constant for all operations
//Space: n where n is the capacity
class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> keyToNode; // Map to store key-node mappings
    ListNode head; // Dummy head node of the linked list
    ListNode tail; // Dummy tail node of the linked list

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        head = new ListNode(-1, -1); // Initialize dummy head node
        tail = new ListNode(-1, -1); // Initialize dummy tail node
        head.next = tail; // Connect head to tail
        tail.prev = head; // Connect tail to head
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1; // Key not found in the cache
        }

        ListNode node = keyToNode.get(key); // Retrieve node from hashmap
        remove(node); // Remove node from its current position
        add(node); // Add node to the end of the list to mark it as the most recently used
        return node.val; // Return the value associated with the key
    }

    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            ListNode oldNode = keyToNode.get(key); // Retrieve the existing node
            remove(oldNode); // Remove the node from its current position
        }

        ListNode node = new ListNode(key, value); // Create a new node
        keyToNode.put(key, node); // Update the key-node mapping
        add(node); // Add the node to the end of the list

        if (keyToNode.size() > capacity) {
            ListNode nodeToDelete = head.next; // Get the least recently used node
            remove(nodeToDelete); // Remove the node from the list
            keyToNode.remove(nodeToDelete.key); // Remove the key from the hashmap
        }
    }

    public void add(ListNode node) {
        ListNode previousEnd = tail.prev; // Get the node before the tail
        previousEnd.next = node; // Connect the previous end to the new node
        node.prev = previousEnd; // Set the previous node of the new node
        node.next = tail; // Connect the new node to the tail
        tail.prev = node; // Set the previous node of the tail to the new node
    }

    public void remove(ListNode node) {
        node.prev.next = node.next; // Connect the previous node to the next node
        node.next.prev = node.prev; // Connect the next node to the previous node
    }
}