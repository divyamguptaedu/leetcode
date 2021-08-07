"""
Performance:
Runtime: 39 ms, faster than 38.93% of Java online submissions for Daily Temperatures.
Memory Usage: 48.7 MB, less than 61.97% of Java online submissions for Daily Temperatures.
"""

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
        	while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        		result[stack.peek()] = i - stack.peek();
        		stack.pop();
        	}
        	stack.push(i);
        }
        return result;
    }
}