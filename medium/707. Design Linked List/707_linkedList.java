"
Performance:
Runtime: 11 ms, faster than 69.10% of Java online submissions for Design Linked List.
Memory Usage: 51.1 MB, less than 19.51% of Java online submissions for Design Linked List.
"

class MyLinkedList {
    
    private Node head;
    private int size = 0;
    
    private static class Node {
        int value;
        Node next;
        public Node(int value) {
            this(value, null);
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        Node current = head;
        int i = 0;
        
        while (i != index) {
            current = current.next;
            i++;
        }
        
        return current.value;
    }
    
    public void addAtHead(int value) {
        head = new Node(value, head);
        size++;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void addAtTail(int value) {
        if (isEmpty()) {
            addAtHead(value);
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
        size++;
    }
    
    public void addAtIndex(int index, int value) {
        if (index < 0 || index > size) {
            return;
        }
        
        if (index  == size) {
            addAtTail(value);
            return;
        }
        
        if (index == 0) {
            addAtHead(value);
            return;
        }
        
        Node current = head;
        int i = 0;
        
        while (i + 1 != index) {
            i++;
            current = current.next;
        }
        
        Node newNode = new Node(value, current.next);
        current.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        if (index  == 0) {
            head = head.next;
            size--;
            return;
        }
        
        Node current = head;
        int i = 0;
        
        while (i + 1 != index) {
            i++;
            current = current.next;
        }
        
        if (current.next.next == null) {
            current.next = null;
        } else {
            current.next = current.next.next;
        }
        
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */