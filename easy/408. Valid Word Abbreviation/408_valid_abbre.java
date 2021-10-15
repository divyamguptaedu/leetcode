"""
Performance:
Runtime: 1 ms, faster than 97.91% of Java online submissions for Valid Word Abbreviation.
Memory Usage: 37.3 MB, less than 78.30% of Java online submissions for Valid Word Abbreviation.
"""

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {

        if (abbr.length() > word.length()) {
            return false;
        }
        int skipLength = 0;
        int wordIndex = 0;
        
        for (int i = 0; i < abbr.length(); i++) {
            
            char letter = abbr.charAt(i);
            
            if (Character.isLetter(letter)) {
                
                if (skipLength != 0) {
                    wordIndex += skipLength;
                    skipLength = 0;
                }
                if (wordIndex >= word.length() || word.charAt(wordIndex) != letter)
                    return false;
                wordIndex++;
                
            } else {
                
                int no = abbr.charAt(i) - '0';
                if (no == 0 && skipLength == 0)
                    return false;

                skipLength = skipLength * 10 + no;

            }
        }
        return wordIndex + skipLength == word.length();
    }
}