//I used a combination of a HashMap and a doubly linked list to implement the LRUCache. 
//The HashMap stored key-node pairs for O(1) access, while the doubly linked list maintained the order of usage, 
//with the head being the most recently used and the tail the least. 
//For the get method, I moved the accessed node to the head. 
//For put, I added new nodes to the head and removed the tail if the cache exceeded capacity.

//Time: O(1) for all methods.
//Space: O(capacity)
class Node {
    public int key; // Key of the node
    public int val; // Value of the node
    public Node next; // Pointer to the next node
    public Node prev; // Pointer to the previous node

    public Node(int key, int val) {
        this.key = key; // Initialize key
        this.val = val; // Initialize value
        next = null;
        prev = null;
    }
}

class LRUCache {
    private Map<Integer, Node> m; // HashMap for key-node pairs
    private Node head; // Most recently used node
    private Node tail; // Least recently used node
    private int size; // Capacity of the cache

    public LRUCache(int capacity) {
        size = capacity; // Initialize capacity
        m = new HashMap<>(); // Initialize HashMap
        head = new Node(-1, -1); // Dummy head node
        tail = new Node(-1, -1); // Dummy tail node
        head.next = tail; // Link head and tail
        tail.prev = head;
    }

    private void deleteNode(Node p) {
        Node pre = p.prev; // Node before the target node
        Node nex = p.next; // Node after the target node
        pre.next = nex; // Bypass the target node
        nex.prev = pre;
    }

    private void addNode(Node newnode) {
        Node temp = head.next; // Node after the head
        head.next = newnode; // Insert new node after head
        newnode.prev = head;
        newnode.next = temp;
        temp.prev = newnode;
    }

    public int get(int key) {
        if (!m.containsKey(key)) {
            return -1; // Return -1 if key is not present
        }

        Node p = m.get(key); // Retrieve the node
        deleteNode(p); // Move the node to the head
        addNode(p);
        m.put(key, head.next); // Update the HashMap
        return head.next.val; // Return the value
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node c = m.get(key); // Retrieve the node
            deleteNode(c); // Move the node to the head
            c.val = value; // Update the value
            addNode(c);
            m.put(key, head.next); // Update the HashMap
        } else {
            if (m.size() == size) {
                Node prev = tail.prev; // Least recently used node
                deleteNode(prev); // Remove it from the linked list
                Node l = new Node(key, value); // Create a new node
                addNode(l); // Add the new node to the head
                m.remove(prev.key); // Remove it from the HashMap
                m.put(key, head.next); // Add the new node to the HashMap
            } else {
                Node l = new Node(key, value); // Create a new node
                addNode(l); // Add the new node to the head
                m.put(key, head.next); // Add the new node to the HashMap
            }
        }
    }
}

// Example usage:
// LRUCache cache = new LRUCache(capacity);
// int value = cache.get(key);
// cache.put(key, value);
