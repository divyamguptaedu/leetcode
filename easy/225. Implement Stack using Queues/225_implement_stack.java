"
Performance:
Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
Memory Usage: 39.7 MB, less than 98.23% of Java online submissions for Implement Stack using Queues.
"

class MyStack {   
    Queue<Integer> queueOne = new LinkedList<>();
    Queue<Integer> queueTwo = new LinkedList<>();
    
    public MyStack() {    
    }
    
    public void push(int x) {
        if (empty()) {
            queueOne.add(x);
            return;
        }
        while (!queueOne.isEmpty()) {
            queueTwo.add(queueOne.remove());
        }
        queueOne.add(x);
        while(!queueTwo.isEmpty()) {
            queueOne.add(queueTwo.remove());
        }
    }
    
    public int pop() {
        if(empty()) {
            return -1;
        }
        return queueOne.remove();
    }
    
    public int top() {
        if(empty()) {
            return -1;
        }
        return queueOne.peek();
    }
    
    public boolean empty() {
        return (queueOne.isEmpty() && queueTwo.isEmpty());
    }
}