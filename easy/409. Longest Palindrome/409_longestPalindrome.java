//To find the length of the longest palindrome that can be constructed from a given string s, 
//I used a HashSet to track characters. As I iterated through each character in s, 
//if the character was already in the set (characterSet), it indicated a pair for the palindrome, 
//so I removed it from the set and incremented res by 2. If the character wasn't in the set, 
//I added it. After iterating through all characters, any remaining characters in characterSet can 
//potentially form the center of an odd-length palindrome, so I incremented res by 1 if characterSet 
//wasn't empty.

//Time: n
//Space: constant
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> characterSet = new HashSet<>();
        int res = 0;
        // Loop over characters in the string
        for (char c : s.toCharArray()) {
            // If set contains the character, match found
            if (characterSet.contains(c)) {
                characterSet.remove(c);
                // add the two occurrences to our palindrome
                res += 2;
            } else {
                // add the character to the set
                characterSet.add(c);
            }
        }
        // if any character remains, we have at least one unmatched
        // character to make the center of an odd length palindrome.
        if (!characterSet.isEmpty())
            res++;
        return res;
    }
}