//I evaluate the Reverse Polish Notation expression using a stack. 
//I iterate through the tokens. If a token is a digit or a negative number, 
//I push it onto the stack. If it's an operator, 
//I pop the last two operands, perform the operation, and push the result back onto the stack. 
//Finally, I return the result left on the stack, which represents the evaluation of the expression.

//Time: O(n)
//Space: O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); // Create a stack to hold operands
        
        for (String token : tokens) { // Iterate through the tokens
            if (isDigit(token) || (token.length() > 1 && token.charAt(0) == '-' && isDigit(token.substring(1)))) { // Check if token is a digit or a negative number
                int val = Integer.parseInt(token); // Convert token to integer
                stack.push(val); // Push integer onto stack
            } else { // If token is an operator
                int pop1 = stack.pop(); // Pop the last operand from stack
                int pop2 = stack.pop(); // Pop the second last operand from stack
                
                int result = 0; // Initialize variable to hold result of operation
                switch (token) { // Perform operation based on token
                    case "+":
                        result = pop2 + pop1; // Addition
                        break;
                    case "-":
                        result = pop2 - pop1; // Subtraction
                        break;
                    case "*":
                        result = pop2 * pop1; // Multiplication
                        break;
                    case "/":
                        result = pop2 / pop1; // Integer division
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator"); // Throw exception for invalid operator
                }
                stack.push(result); // Push result back onto stack
            }
        }

        return stack.pop(); // Return the final result left on the stack
    }

    private boolean isDigit(String s) { // Helper method to check if a string is a digit
        try {
            Integer.parseInt(s); // Try parsing the string as an integer
            return true; // If successful, it's a digit
        } catch (NumberFormatException e) {
            return false; // If exception caught, it's not a digit
        }
    }
}
