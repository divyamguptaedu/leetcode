"""
Performance: 
Runtime: 2 ms, faster than 70.28% of Java online submissions for Longest Valid Parentheses.
Memory Usage: 38.8 MB, less than 90.73% of Java online submissions for Longest Valid Parentheses.
"""

public class Solution {

    public int longestValidParentheses(String s) {
        int maximum = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maximum = Math.max(maximum, i - stack.peek());
                }
            }
        }
        return maximum;
    }
}