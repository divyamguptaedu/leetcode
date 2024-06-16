//To determine if two strings are anagrams, I first checked if their lengths were different. 
//If they were, I returned false. 
//I then created an array of size 26 to count character occurrences in the first string. 
//For each character in the first string, I incremented the corresponding index in the array. 
//For the second string, I decremented the corresponding index. 
//If any value in the array went negative, I returned false, indicating the characters did not match. 
//If all checks passed, I returned true, confirming the strings were anagrams.

//Time: n
//Space: constant
class Solution {
    public boolean isAnagram(String str1, String str2) {
        // Check if the lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Create a table to count character occurrences
        int[] charCount = new int[26];
        
        // Increment count for each character in the first string
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;
        }
        
        // Decrement count for each character in the second string
        for (int i = 0; i < str2.length(); i++) {
            charCount[str2.charAt(i) - 'a']--;
            // If any count goes negative, the strings are not anagrams
            if (charCount[str2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        
        // If all counts are zero, the strings are anagrams
        return true;
    }
}