class Node {
    int value;
    Node next;
    Node prev;

    Node(int value) {
        this.value = value;
    }
}
class MyCircularDeque {
    Node head;
    Node tail;
    int size;
    int maxSize;

    public MyCircularDeque(int k) {
        head = null;
        tail = null;
        size = 0;
        maxSize = k; 
    }
    
    public boolean insertFront(int value) {
        if (size == maxSize) {
            return false;
        } else {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
            return true;
        }
    }
    
    public boolean insertLast(int value) {
        if (size == maxSize) {
            return false;
        } else {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
            return true;
        }
    }
    
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            return true;
        }

    }
    
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
            return true;
        }
    }
    
    public int getFront() {
        if (size == 0) {
            return -1;
        } else {
            return head.value;
        }
    }
    
    public int getRear() {
        if (size == 0) {
            return -1;
        } else {
            return tail.value;
        }

    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */