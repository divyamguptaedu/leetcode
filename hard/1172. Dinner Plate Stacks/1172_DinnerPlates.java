"""
Performance:
Runtime: 83 ms, faster than 98.36% of Java online submissions for Dinner Plate Stacks.
Memory Usage: 203.5 MB, less than 80.33% of Java online submissions for Dinner Plate Stacks.
"""

class DinnerPlates {
    int capacity;
    List<Stack<Integer>> dinnerPlates;
    PriorityQueue<Integer> left;
    
    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        dinnerPlates = new ArrayList<>();
        left = new PriorityQueue<>();
    }
    
    public void push(int val) {
        if (left.isEmpty()) {
            Stack<Integer> stackOne = new Stack<>();
            stackOne.push(val);
            dinnerPlates.add(stackOne);
            if (capacity > 1) {
                left.add(dinnerPlates.size() - 1);
            }
        } else {
            Stack<Integer> stackTwo = dinnerPlates.get(left.peek());
            stackTwo.push(val);
            if (stackTwo.size() == capacity) {
                left.poll();
            }
        }
    }
    
    public int pop() {
        for (int i = dinnerPlates.size() - 1; i > -1 && dinnerPlates.get(i).empty(); i--) {
            dinnerPlates.remove(i);
            left.remove(i);
        }
        return popAtStack(dinnerPlates.size() - 1);
    }
    
    public int popAtStack(int index) {
        if (index < 0 || index >= dinnerPlates.size()) {
            return -1;
        }
        Stack<Integer> stackThree = dinnerPlates.get(index);
        if (stackThree.empty()) {
            return -1;
        }
        if (stackThree.size() == capacity) {
            left.add(index);
        } 
        return stackThree.pop();
    }
}
/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */