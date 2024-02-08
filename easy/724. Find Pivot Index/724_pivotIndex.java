"
Performance:
Runtime: 15 ms, faster than 83.90% of Java online submissions for Max Stack.
Memory Usage: 39.9 MB, less than 93.69% of Java online submissions for Max Stack.
"

class MaxStack {

    private List<Integer> stack; 
    private Queue<Integer> queue; 

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new ArrayList<>();
        queue = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void push(int x) {
        stack.add(x);
        queue.add(x);
    }
    
    public int pop() {
        int value = stack.remove(stack.size() - 1);
        queue.remove(value);
        return value;
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int peekMax() {
        return queue.peek();
    }
    
    public int popMax() {
        int value = queue.poll();
        for (int i = stack.size()-1 ; i > 0; i--) {
            if(value == stack.get(i)) {
                return stack.remove(i);
            }
        }
        return value;
    }
}