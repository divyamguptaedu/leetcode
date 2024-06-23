//I utilized a HashMap to count frequencies of characters in s. 
//First, I populated the HashMap with character counts from s. 
//Then, I iterated through t to find the character that didn't match the counts in the HashMap, 
//indicating it was the added character. Upon finding this character, I returned it.
//Time: n
//Space: constant
class Solution {
    public char findTheDifference(String s, String t) {

        char extraChar = '\0';

        // Prepare a counter for string s.
        // This hash map holds the characters as keys and respective frequency as value.
        HashMap<Character, Integer> counterS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counterS.put(ch, counterS.getOrDefault(ch, 0) + 1);
        }

        // Iterate through string t and find the character which is not in s.
        for (int i = 0; i < t.length(); i += 1) {
            char ch = t.charAt(i);
            int countOfChar = counterS.getOrDefault(ch, 0);
            if (countOfChar == 0) {
                extraChar = ch;
                break;
            } else {

                // Once a match is found we reduce frequency left.
                // This eliminates the possibility of a false match later.
                counterS.put(ch, countOfChar - 1);
            }
        }
        return extraChar;
    }
}