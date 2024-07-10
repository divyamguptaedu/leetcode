// A parentheses string is valid if and only if:
// It is the empty string,
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
// You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        
        return left + right;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage and testing
        String s1 = "())";
        System.out.println("Minimum parentheses to add for \"" + s1 + "\": " + solution.minAddToMakeValid(s1)); // Output: 1
        
        String s2 = "(((";
        System.out.println("Minimum parentheses to add for \"" + s2 + "\": " + solution.minAddToMakeValid(s2)); // Output: 3
        
        String s3 = "()";
        System.out.println("Minimum parentheses to add for \"" + s3 + "\": " + solution.minAddToMakeValid(s3)); // Output: 0
        
        String s4 = "()))((";
        System.out.println("Minimum parentheses to add for \"" + s4 + "\": " + solution.minAddToMakeValid(s4)); // Output: 4
    }
}