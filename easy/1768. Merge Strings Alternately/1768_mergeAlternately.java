//I first determined the lengths of both strings. Using a loop, I iterated up to the maximum length of the two strings. 
//In each iteration, I appended the current character from word1 (if available) followed by the current character from word2 (if available) to a StringBuilder object. 
//This ensured characters were added alternately. After the loop, I returned the merged string created from the StringBuilder.

//Time: m+n
//Space: constant
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m) {
                result.append(word1.charAt(i));
            }
            if (i < n) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }
}