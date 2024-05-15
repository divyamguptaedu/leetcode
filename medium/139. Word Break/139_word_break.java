//I initialized a dynamic programming array to track whether substrings up to the current index could be segmented. 
//Then, I iterated through the string and the word dictionary, checking if substrings matched words in the dictionary. 
//If a match occurred, I updated the dynamic programming array accordingly. 
//Finally, we return the last index of dp to see if the answer is true or false.

//Time: O(nmk) where n is the length of s, m is the length of wordDict, and k is the avg len of words in wordDict.
//Space: O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                // Handle out of bounds case
                if (i < word.length() - 1) {
                    continue;
                }

                if (i == word.length() - 1 || dp[i - word.length()]) {
                    if (
                        s.substring(i - word.length() + 1, i + 1).equals(word)
                    ) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }
}