//I maintained an array representing the frequency of characters in the magazine. 
//First, I counted the frequency of each character in the magazine. 
//Then, I iterated through the characters of the ransomNote, 
//decrementing the count of each character found in the magazine array. 
//If the count becomes zero or the character is not found in the magazine, I return false. 
//If all characters of the ransomNote can be constructed, I return true. 

//Time: m + n where m is the len of random note and n is the len of magazine.
//Space: O(1)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // If the length of ransomNote is greater than magazine, it cannot be constructed
        if (ransomNote.length() > magazine.length()) return false;
        // Array to store the frequency of each character in the magazine
        char[] magazineFreq = new char[26];
        // Count the frequency of each character in the magazine
        for (char ch : magazine.toCharArray()) {
            magazineFreq[ch - 'a']++;
        }
        // Check if ransomNote can be constructed using characters from magazine
        for (char ch : ransomNote.toCharArray()) {
            // If the frequency of the character in magazine is zero, return false
            if (magazineFreq[ch - 'a'] == 0) {
                return false;
            }
            // Decrement the frequency of the character in magazine
            magazineFreq[ch - 'a']--;
        }
        // If all characters of ransomNote can be constructed, return true
        return true;
    }
}
