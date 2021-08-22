class Solution {
    public int calculate(String s) {

        if (s == null || s.isEmpty()) {
        	return 0;
        }
        int length = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int current = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                current = (current * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '-') {
                    stack.push(-current);
                }
                else if (operation == '+') {
                    stack.push(current);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * current);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / current);
                }
                operation = currentChar;
                current = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
