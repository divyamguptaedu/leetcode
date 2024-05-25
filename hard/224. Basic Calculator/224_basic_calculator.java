//I processed the string character by character, maintaining a running sum and the current sign. 
//For digits, I built the number and adjusted the sum based on the current sign. 
//When encountering a '(', I pushed the current sum and sign onto the stack and reset them. 
//When encountering a ')', I popped the sign and sum from the stack and updated the current sum accordingly. 
//For '-', I toggled the sign. 
//This allowed handling nested expressions correctly using the stack for intermediate results and signs.

//Time: O(n) where n is the length of the string s
//Space: O(n)

class Solution {
    public int calculate(String s) {
        int sum = 0; // To store the running total
        int sign = 1; // To store the current sign (+1 or -1)
        Stack<Integer> st = new Stack<>(); // Stack to store intermediate sums and signs

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is a digit, form the number
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0'); // Form the number
                    i++;
                }
                i--; // Adjust the index after inner loop
                sum += val * sign; // Add the number to sum with the current sign
                sign = 1; // Reset the sign to default

            // If the character is '(', push the current sum and sign to stack
            } else if (ch == '(') {
                st.push(sum);
                st.push(sign);
                sum = 0; // Reset sum for the new sub-expression
                sign = 1; // Reset sign for the new sub-expression

            // If the character is ')', pop from stack and evaluate the expression
            } else if (ch == ')') {
                sum = sum * st.pop() + st.pop(); // Apply the previous sign and add to previous sum

            // If the character is '-', toggle the sign
            } else if (ch == '-') {
                sign *= -1;
            }
        }
        return sum; // Return the final evaluated sum
    }
}