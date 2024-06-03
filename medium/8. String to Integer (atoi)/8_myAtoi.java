//Just follow the rules.
//I iterated through the string, skipping leading whitespaces and 
//determining sign based on the next character ('+' or '-'). 
//Then, I parsed digits until a non-digit or end of string, 
//avoiding overflow by checking against the integer limits. 
//Finally, I returned the parsed integer with the appropriate sign.

//Time: O(n)
//Space: O(1)
class Solution {
    public int myAtoi(String s) {
        int n = s.length(); // Get the length of the string
        int i = 0; // Initialize the index
        int sign = 1; // Initialize the sign as positive
        
        // Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i >= n) {
            return 0; // If end of string is reached, return 0
        }

        // Check for sign
        if (s.charAt(i) == '-') {
            sign = -1; // If negative sign encountered, update sign
        }
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++; // Move to next character if sign is present
        }

        if (i >= n) {
            return 0; // If end of string is reached, return 0
        }

        // Parse digits
        int num = 0; // Initialize the result
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int x = s.charAt(i) - '0'; // Convert character to integer
            // Check for overflow by dividing max or min value by 10, since we multiply by 10 to adding the next number
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE; // Return max value if positive overflow
                } else {
                    return Integer.MIN_VALUE; // Return min value if negative overflow
                }
            }
            num = num * 10 + x; // Update result
            i++; // Move to next character
        }
        return num * sign; // Return result with appropriate sign
    }
}