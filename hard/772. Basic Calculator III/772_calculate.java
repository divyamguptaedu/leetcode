//To implement a basic calculator for evaluating an expression string, 
//I used recursion and an index to process the string exactly once. 
//I defined a helper method to handle nested expressions within parentheses. 
//I initialized variables to keep track of the current result, the previous number, and the current number being processed. 
//Depending on the operator encountered, I updated the result and the previous number accordingly. 
//When encountering an open parenthesis, I called the helper method recursively to evaluate the expression within the parentheses. 
//If a closing parenthesis was encountered, I returned the result for the current level.

//Time: O(n)
//Space: O(n)
class Solution {
    int idx; // Shared index to scan the input string (exactly once) between recursion calls

    public int calculate(String s) {
        idx = 0; // Each time this method is called, index should start from 0
        return calc2(s);
    }

    public int calc2(String s) { // Handles the calculation including '(' and ')'
        int res = 0, pre = 0, num = 0, n = s.length();
        char sign = '+';

        while (idx < n) {
            char c = s.charAt(idx++);
            if (c == '(')
                num = calc2(s); // Recursively calculate everything between '(' and ')'
            else if (c >= '0' && c <= '9')
                num = num * 10 + c - '0'; // Handle multi-digit numbers
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == ')' || idx == n) { // Different stop points for calculation
                switch (sign) {
                    case '+':
                        res += pre;
                        pre = num;
                        break;
                    case '-':
                        res += pre;
                        pre = -num;
                        break;
                    case '*':
                        pre *= num;
                        break;
                    case '/':
                        pre /= num;
                        break;
                }
                if (c == ')')
                    return res + pre; // Finish and exit current level (recursive) processing
                num = 0;
                sign = c;
            }
        }

        return res + pre;
    }
}