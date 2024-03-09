class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        return helper(str1, str2, 0, 0);
    }
        
    private boolean helper(String str1, String str2, int indexOne, int indexTwo) {
        if (indexTwo >= str2.length()) {
            return true;
        }
        if (indexOne >= str1.length()) {
            return false;
        }
        char c1 = str1.charAt(indexOne);
        char c2 = str2.charAt(idx2);
        if (rotateCharacter(c1) == c2 || c1 == c2) {
            return sequenceHelper(str1, str2, indexOne + 1, indexTwo + 1);
        }
        return sequenceHelper(str1, str2, indexOne + 1, indexTwo);
    }

    public static char rotateCharacter(char c) {
        return (char) (((c - 'a' + 1) % 26) + 'a');
    }
}