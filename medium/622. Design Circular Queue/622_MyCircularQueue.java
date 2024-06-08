//I designed a circular queue using a linked list.
//In the constructor, I set the capacity of the queue. 
//The enQueue operation adds elements to the tail of the queue,
//while the deQueue operation removes elements from the head.
//I used pointers to keep track of the head and tail nodes.
//Front and Rear methods return the values of the head and tail nodes, respectively.
//isEmpty and isFull methods check if the queue is empty or full,
//respectively, based on the count of elements.

//Time: constant
//Space: capacity
class Node {
    public int value;
    public Node next;

    // Node constructor
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class MyCircularQueue {

    private Node head, tail; // Pointers to the head and tail nodes
    private int count; // Number of elements in the queue
    private int capacity; // Capacity of the circular queue

    // Initialize circular queue with capacity k
    public MyCircularQueue(int k) {
        this.capacity = k;
    }

    // Insert element into circular queue. Return true if successful.
    public boolean enQueue(int value) {
        if (this.count == this.capacity)
            return false; // Queue is full

        Node newNode = new Node(value); // Create new node
        if (this.count == 0) {
            head = tail = newNode; // First node added
        } else {
            tail.next = newNode; // Add node to tail
            tail = newNode; // Update tail
        }
        this.count++;
        return true;
    }

    // Delete element from circular queue. Return true if successful.
    public boolean deQueue() {
        if (this.count == 0)
            return false; // Queue is empty
        this.head = this.head.next; // Move head to next node
        this.count--;
        return true;
    }

    // Get the front item from the queue
    public int Front() {
        return this.count == 0 ? -1 : this.head.value; // Return front value or -1 if queue is empty
    }

    // Get the last item from the queue
    public int Rear() {
        return this.count == 0 ? -1 : this.tail.value; // Return rear value or -1 if queue is empty
    }

    // Check if circular queue is empty
    public boolean isEmpty() {
        return this.count == 0;
    }

    // Check if circular queue is full
    public boolean isFull() {
        return this.count == this.capacity;
    }
}