//I first counted the unique characters on the string using a frequency array. 
//Then, I traversed the string while updating the count of unique characters
//on both sides.
//If the number of unique characters on the left matched the number on the right
//at any point, I incremented the result. 
//This ensured that I found all good splits where the number of distinct characters 
//on both sides was the same.

//Example Input: aacaba
//We will make the freq map: a -> 4, c -> 1, b -> 1
//Then we will take the first char a, decrement the freq, increment the uniqueOnLeft, won't decrement uniqueOnLeft because freq is still >0.
//In such a way, we will check all possibilities, and make the result.

//Time: n
//Space: constant because its at max 26.
class Solution {
    public int numSplits(String s) {
        int res = 0;

        int[] freq = new int[26];
        int uniqueOnLeft = 0;
        int uniqueOnRight = 0;
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                uniqueOnRight++;
            }
            freq[c - 'a']++;
        }

        // Set<Character> set = new HashSet<>();
        boolean[] uniqueCharsOnLeft = new boolean[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']--;
            if (!uniqueCharsOnLeft[c - 'a']) {
                uniqueOnLeft++;
                uniqueCharsOnLeft[c - 'a'] = true;
            }
            if (freq[c - 'a'] == 0) {
                uniqueOnRight--;
            }

            if (uniqueOnLeft == uniqueOnRight) {
                res++;
            }
        }

        return res;
    }
}