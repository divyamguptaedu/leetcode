// Given a string s of '(' , ')' and lowercase English characters.
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
// Formally, a parentheses string is valid if and only if:
// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.

import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        // First pass: remove invalid closing parentheses and track positions of opening parentheses
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                sb.append(ch);
                stack.push(sb.length() - 1); // store the position in the StringBuilder
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // valid closing parentheses, remove corresponding '(' from stack
                    sb.append(ch);
                }
            } else {
                sb.append(ch); // append non-parentheses characters
            }
        }
        
        // Second pass: remove any unmatched opening parentheses left in the stack
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage and testing
        String s1 = "lee(t(c)o)de)";
        System.out.println("Valid string after removing parentheses from \"" + s1 + "\": " + solution.minRemoveToMakeValid(s1)); // Output: "lee(t(c)o)de"
        
        String s2 = "a)b(c)d";
        System.out.println("Valid string after removing parentheses from \"" + s2 + "\": " + solution.minRemoveToMakeValid(s2)); // Output: "ab(c)d"
        
        String s3 = "))((";
        System.out.println("Valid string after removing parentheses from \"" + s3 + "\": " + solution.minRemoveToMakeValid(s3)); // Output: ""
    }
}