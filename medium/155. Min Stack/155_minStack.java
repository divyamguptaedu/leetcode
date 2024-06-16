//I used two stacks: one for regular values and another for tracking minimum values. 
//When pushing, I added the value to the main stack and also updated the min stack with the 
//current minimum. If the min stack was empty, I pushed the value. Otherwise, 
//I pushed the smaller of the current value and the top of the min stack. For pop, 
//I removed the top values from both stacks. The top and getMin methods retrieved the 
//respective values from the main and min stacks.

//Time: constant
//Space: n
class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        // Push value onto the main stack
        mainStack.push(value);
        
        // Push the minimum value onto the min stack
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {
            minStack.push(Math.min(minStack.peek(), value));
        }
    }

    public void pop() {
        // Pop the top values from both stacks
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        // Return the top value of the main stack
        return mainStack.peek();
    }

    public int getMin() {
        // Return the top value of the min stack
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */