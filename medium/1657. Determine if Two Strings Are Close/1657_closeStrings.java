//In solving the problem of determining if two strings are "close," my approach involved utilizing 
//frequency maps to capture the counts of characters in both word1 and word2. 
//Firstly, I checked if the lengths of the two strings were equal; if not, 
//they couldn't be rearranged into each other, so I returned false.
//Then, I populated frequency arrays word1Map and word2Map where each index represented a 
//character ('a' to 'z'), and its value represented the count of occurrences in the respective 
//string. If there was any discrepancy in the presence of characters 
//(i.e., one string had a character that the other didn't), 
//they couldn't be transformed into each other, and I returned false.
//Next, I sorted both frequency arrays and compared them. 
//If the sorted arrays were identical, it meant that both strings could be rearranged into 
//each other using the allowed operations, and I returned true.

//Time: n
//Space: constant
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int word1Map[] = new int[26];
        int word2Map[] = new int[26];
        for (char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((word1Map[i] == 0 && word2Map[i] > 0) ||
                    (word2Map[i] == 0 && word1Map[i] > 0)) {
                return false;
            }
        }
        Arrays.sort(word1Map);
        Arrays.sort(word2Map);
        return Arrays.equals(word1Map, word2Map);
    }
}