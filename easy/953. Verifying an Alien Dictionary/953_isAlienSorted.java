//I created a mapping of each character in the alien language to its corresponding index based 
//on the given order. Then, I compared each pair of adjacent words to ensure they were in the 
//correct lexicographical order according to the alien dictionary. For each character comparison, 
//if the current word was longer but identical up to that point with the next word, 
//I returned false. Otherwise, I checked the order of differing characters using the 
//created mapping and returned false if they were out of order.

//Time: O(m) where m is the total number of characters in words.
//Space: O(1)

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26]; // Create a map for character order
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i; // Map each character to its order
        }

        for (int i = 0; i < words.length - 1; i++) { // Compare each word with the next word
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i + 1].length()) {
                    return false; // Current word is longer but identical up to that point
                }
                
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int currentWordChar = words[i].charAt(j) - 'a';
                    int nextWordChar = words[i + 1].charAt(j) - 'a';
                    if (orderMap[currentWordChar] > orderMap[nextWordChar]) {
                        return false; // Characters are out of order
                    } else {
                        break; // Correct order, move to next comparison
                    }
                }
            }
        }

        return true; // All words are in the correct order
    }
}