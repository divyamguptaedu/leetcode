"""
Performance:
Runtime: 10 ms, faster than 11.66% of Java online submissions for Design Circular Queue.
Memory Usage: 48.5 MB, less than 23.95% of Java online submissions for Design Circular Queue.
"""

class MyCircularQueue {
    
    int beginning;
    int ending;
    int[] queue;
    int maximumSize;
    int size;
    
    public MyCircularQueue(int k) {
        queue = new int[k];
        maximumSize = k;
        beginning = -1;
        ending = -1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (beginning == -1) {
            beginning++;
        }
        ending = (ending + 1) % maximumSize;
        queue[ending] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            beginning = (beginning + 1) % maximumSize;
            size--;
            return true;
        }
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[beginning];
        }
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[ending];
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maximumSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */