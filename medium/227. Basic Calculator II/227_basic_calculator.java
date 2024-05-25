//I iterated through the string, maintaining currentNumber, lastNumber, and result variables. 
//currentNumber held the ongoing number being built from digits. 
//lastNumber stored the result of the last evaluated sub-expression. 
//result accumulated the total sum. For each character, if it was a digit, I updated currentNumber. 
//If it was an operator or the end of the string, 
//I processed the previous operator: adding/subtracting lastNumber to/from result for addition/subtraction, and 
//updating lastNumber with multiplication/division results. 
//Finally, I added lastNumber to result after the loop to account for the last operation.

//Time: O(n)
//Space: O(1)
class Solution {
    public int calculate(String s) {
        // Check if the string is null or empty
        if (s == null || s.isEmpty())
            return 0;
        
        int length = s.length(); // Length of the input string
        int currentNumber = 0, lastNumber = 0, result = 0; // Initialize variables
        char operation = '+'; // Start with a '+' operation
        
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i); // Current character in the string
            
            // If the current character is a digit, update currentNumber
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            
            // If the current character is an operator or we are at the end of the string
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                // Process the previous operation
                if (operation == '+' || operation == '-') {
                    result += lastNumber; // Add lastNumber to result
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber; // Update lastNumber for +/-
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber; // Update lastNumber for *
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber; // Update lastNumber for /
                }
                
                operation = currentChar; // Update the operation
                currentNumber = 0; // Reset currentNumber for the next number
            }
        }
        
        result += lastNumber; // Add the last number to the result
        return result; // Return the final result
    }
}