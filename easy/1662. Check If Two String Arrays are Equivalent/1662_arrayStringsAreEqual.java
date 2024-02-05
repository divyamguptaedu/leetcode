class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            string1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            string2.append(word2[i]);
        }
        return string1.toString().equals(string2.toString());
    }
}