//I compared characters from the two string arrays, 
//using pointers for each array and each string within the arrays. 
//I incremented the pointers to traverse through each character and checked 
//if the characters at the current pointers were equal. 
//If a character mismatch occurred, I returned false. 
//If the end of a string was reached, 
//I moved to the next string and reset the string pointer. 
//Finally, I checked if both arrays were completely traversed 
//to ensure they represented the same string.

//Time: n*k where n is the #strings, and k is max len of a string in it.
//Space: constant
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Pointers to mark the current word in the given two lists.
        int word1Pointer = 0, word2Pointer = 0;
        // Pointers to mark the character in the string pointed by the above pointers.
        int string1Pointer = 0, string2Pointer = 0;

        // While we still have the string in any of the two given lists.
        while (word1Pointer < word1.length && word2Pointer < word2.length) {
            // If the characters at the two string are same, increment the string pointers
            // Otherwise return false.
            if (word1[word1Pointer].charAt(string1Pointer++) != word2[word2Pointer].charAt(string2Pointer++)) {
                return false;
            }
            // If the string pointer reaches the end of string in the list word1,
            // Move to the next string in the list and, reset the string pointer to 0.
            if (string1Pointer == word1[word1Pointer].length()) {
                word1Pointer++;
                string1Pointer = 0;
            }
            // If the string pointer reaches the end of string in the list word2,
            // Move to the next string in the list and, reset the string pointer to 0.
            if (string2Pointer == word2[word2Pointer].length()) {
                word2Pointer++;
                string2Pointer = 0;
            }
        }
        // Strings in both the lists should be traversed.
        return word1Pointer == word1.length && word2Pointer == word2.length;
    }
}