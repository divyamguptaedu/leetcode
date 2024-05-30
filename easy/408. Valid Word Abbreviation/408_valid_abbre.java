//I implemented a method to check if a given word matches its abbreviation. 
//I iterated through the abbreviation, 
//maintaining a count of numeric values to skip the corresponding characters in the word. 
//If a character was a digit, I updated the count, ensuring it wasn't zero. 
//When encountering a non-digit, I checked if the character matched the corresponding 
//character in the word after accounting for the skipped characters. 
//Finally, I ensured the entire word was traversed correctly, including any remaining skipped characters.

//Time: O(n+m) where n is the length of the word, m is the length of the abbreviation.
//Space: O(1)

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int total = 0; // Tracks the current numeric value in the abbreviation
        int length = 0; // Tracks the current position in the word
        for (int i = 0; i < abbr.length(); i++) {
            char ch = abbr.charAt(i);
            if (Character.isDigit(ch)) {
                if (total == 0 && ch - '0' == 0) { // Leading zeros are not allowed
                    return false;
                }
                total = total * 10 + ch - '0'; // Update the numeric value
            } else {
                length += total; // Move the length pointer by the numeric value
                total = 0; // Reset the numeric value
                if (length >= word.length() || word.charAt(length) != ch) { // Check if characters match
                    return false;
                }
                length++; // Move to the next character
            }
        }
        return word.length() == length + total; // Check if the entire word was traversed correctly
    }
}