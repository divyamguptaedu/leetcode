"""
Performance:
Runtime: 7 ms, faster than 52.95% of Java online submissions for Design Circular Deque.
Memory Usage: 48.4 MB, less than 61.48% of Java online submissions for Design Circular Deque.
"""

class MyCircularDeque {
    int[] array;
    int count;
    int head;
    int tail;

    public MyCircularDeque(int k) {
        array = new int[k];
        head = -1;
        tail = -1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head + array.length - 1) % array.length;
        array[head] = value;
        if (isEmpty()) {
            tail = head;
        }
        count++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % array.length;
        array[tail] = value;
        if (isEmpty()) {
            head = tail;
        }
        count++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % array.length;
        count--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail + array.length - 1) % array.length;
        count--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return array[tail];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == a.length;
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