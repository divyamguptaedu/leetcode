//Used a two pointer approach
//Iterated through the string from both ends simultaneously, tracking the count of open and close parentheses, along with asterisks. 
//It adjusts counts based on encountered characters, ensuring left parentheses are followed by corresponding right parentheses. 
//If counts turn negative at any point, the string becomes invalid. 
//However, if both open and close counts remain non-negative throughout the traversal, the string is valid. 

//Time: O(n)
//Space: O(1)
class Solution {
    public boolean checkValidString(String s) {
        int openCount = 0;
        int closeCount = 0;
        int length = s.length() - 1;

        // Traverse the string from both ends simultaneously
        for (int i = 0; i <= length; i++) {
            // Count open parentheses or asterisks
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else {
                openCount--;
            }

            // Count close parentheses or asterisks
            if (s.charAt(length - i) == ')' || s.charAt(length - i) == '*') {
                closeCount++;
            } else {
                closeCount--;
            }

            // If at any point open count or close count goes negative, the string is
            // invalid
            if (openCount < 0 || closeCount < 0) {
                return false;
            }
        }

        // If open count and close count are both non-negative, the string is valid
        return true;
    }
}