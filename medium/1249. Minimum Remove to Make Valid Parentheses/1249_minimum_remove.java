//I tackled the problem of making a string valid by removing the minimum number of parentheses. 
//I used a two-pass approach: in the first pass, I traversed the string to identify and mark excess closing parentheses. 
//In the second pass, I marked any excess opening parentheses by traversing from the end. 
//Finally, I constructed the resulting string by filtering out the marked characters.

//Time: O(n)
//Space: O(n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        // Convert input string to character array for easier manipulation
        char[] arr = s.toCharArray();
        int openParenthesesCount = 0; // Counter for open parentheses

        // First pass: mark excess closing parentheses with '*'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                openParenthesesCount++;
            } else if (arr[i] == ')') {
                if (openParenthesesCount == 0) {
                    arr[i] = '*'; // Mark excess closing parentheses
                } else {
                    openParenthesesCount--;
                }
            }
        }

        // Second pass: mark excess opening parentheses from the end
        for (int i = arr.length - 1; i >= 0; i--) {
            if (openParenthesesCount > 0 && arr[i] == '(') {
                arr[i] = '*'; // Mark excess opening parentheses
                openParenthesesCount--;
            }
        }

        // Filter out marked characters and store the result in the character array
        int p = 0; // Pointer for updating the character array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                arr[p++] = arr[i];
            }
        }

        // Construct the result string from the filtered character array
        return new String(arr, 0, p);
    }
}