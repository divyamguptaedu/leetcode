//To solve this question, one way is to create a frequency array, add it to a pq, and then query the first two most frequent chars and build the result.
//However, this approach takes nlogn time. We can solve this question in n time as well using the odd-even strategy. So, what we will do is that we will
//build the frequency array, get the max frequency, and the most frequent letter on the fly. We will check if the max frequency is greater than half
//of the length, if yes, return empty as it wont be possible to make the result. If not, we place the most frequent letter in all the even places starting from 0.
//Once that is done, we do the same for the next elements, and just ensure that once the index is out of the bounds, we set it back to 1. 
//Time: O(n)
//Space: O(k)
class Solution {
    public String reorganizeString(String s) {
        int maxCount = 0;
        int letter = 0;
        var charCounts = new int[26];
        for (char c : s.toCharArray()) { //make the frequency array and get the maxCount and the most frequent letter
            charCounts[c - 'a']++;
            if (charCounts[c - 'a'] > maxCount) {
                maxCount = charCounts[c - 'a'];
                letter = c - 'a';
            };
        }

        if (maxCount > (s.length() + 1) / 2) { //if an element is present more than half of the times, then just return empty string
            return "";
        }
        char[] ans = new char[s.length()];
        int index = 0;

        // Place the most frequent letter
        while (charCounts[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charCounts[letter]--;
        }

        // Place rest of the letters in any order
        for (int i = 0; i < charCounts.length; i++) {
            while (charCounts[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }

        return String.valueOf(ans);
    }
}
