// Runtime: 78 ms, faster than 15.05% of Java online submissions for Maximum Frequency Stack.
// Memory Usage: 82.7 MB, less than 16.72% of Java online submissions for Maximum Frequency Stack.

class FreqStack {
    HashMap<Integer,Integer> valueMap = new HashMap<>();
    HashMap<Integer,Stack<Integer>> stack = new HashMap<>();
    int max = 0;
    public void push(int val) {
        valueMap.put(val, valueMap.getOrDefault(val, 0) + 1);
        int frequency = valueMap.get(val);
        if (stack.containsKey(frequency)) {
            stack.get(frequency).push(val);
        } else {
            stack.put(frequency, new Stack<Integer>());
            stack.get(frequency).push(val);
        }
        max = Math.max(max, frequency);
    }
    
    public int pop() {
        int result = stack.get(max).pop();
        valueMap.put(result, valueMap.get(result) - 1);
        if (stack.get(max).size() == 0) {
            max--;
        }
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */