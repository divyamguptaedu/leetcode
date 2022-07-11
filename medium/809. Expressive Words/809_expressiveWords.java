"
Performance:
Runtime: 76 ms, faster than 89.57% of Java online submissions for Expressive Words.
Memory Usage: 21.2 MB, less than 79.84% of Java online submissions for Expressive Words.
"

class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word: words) {
            if (helper(word, s)) {
                count++;
            }
        }
        return count;
    }
    private boolean helper(String word, String s) {
        int index = 0;
        int wordIndex = 0;
        while (index < s.length() && wordIndex < word.length()) {
            char letter = word.charAt(wordIndex);
            int count = 0;
            while (wordIndex < word.length() && word.charAt(wordIndex) == letter) {
                wordIndex++;
                letter++;
            } 
            char sLetter = s.charAt(index);
            int sCount = 0;
            while (index < s.length() && s.charAt(index) == sLetter) {
                index++;
                sCount++;
            }

            if (letter != sLetter) {
                return false;
            }
            if (count > sCount) {
                return false;
            }
            if (count != sCount && sCount < 3) {
                return false;
            }
        }
        if (index == s.length() && wordIndex == word.length()) {
            return true;
        }
        else return false;
    }
}