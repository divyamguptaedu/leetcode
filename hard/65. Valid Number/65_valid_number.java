//I parsed the string character by character, setting flags to track if I've seen a digit, exponent, or dot. 
//If a digit is found, I mark it. If a sign appears and it's not right after 'e' or 'E', it's invalid. 
//For exponent ('e' or 'E'), I check if it's seen before and if a digit was seen before it. 
//If it's a dot, I check if it's not seen before or after an exponent. 
//Anything else invalidates the number. 
//Finally, if no digit was seen, it's invalid.

//Time: O(n)
//Space: O(1)
class Solution {
    public boolean isNumber(String s) {
        // Flags to track if digits, exponent, or dot have been seen
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;
        
        // Parsing the string character by character
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                // Mark if a digit is found
                seenDigit = true;
            } else if (curr == '+' || curr == '-') {
                // Check if a sign is valid
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false; // Invalid sign position
                }
            } else if (curr == 'e' || curr == 'E') {
                // Check if an exponent is valid
                if (seenExponent || !seenDigit) {
                    return false; // Invalid exponent position or no digit before it
                }
                seenExponent = true; // Mark exponent as seen
                seenDigit = false; // Reset seenDigit for the exponent part
            } else if (curr == '.') {
                // Check if a dot is valid
                if (seenDot || seenExponent) {
                    return false; // Invalid dot position or after an exponent
                }
                seenDot = true; // Mark dot as seen
            } else {
                return false; // Invalid character
            }
        }
        
        // Return true if at least one digit is seen
        return seenDigit;
    }
}