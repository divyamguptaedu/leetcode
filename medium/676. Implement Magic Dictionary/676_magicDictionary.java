"
Performance:
Runtime: 36 ms, faster than 94.03% of Java online submissions for Implement Magic Dictionary.
Memory Usage: 54.6 MB, less than 57.46% of Java online submissions for Implement Magic Dictionary.
"

class MagicDictionary {
    String[] magicDictionary;
    
    public MagicDictionary() {}
    
    public void buildDict(String[] dictionary) {
        magicDictionary = dictionary;
    }
    
    public boolean canMatch(String searchWord , String dictWord) {
        if (dictWord.length() == searchWord.length() && !searchWord.equals(dictWord)) {
            for (int i = 0 ; i < dictWord.length() ; i++) {
                if (searchWord.charAt(i) != dictWord.charAt(i)) {
                    return searchWord.substring(i + 1).equals(dictWord.substring(i + 1));
                }
            }
        }
        return false;
    }
    
    public boolean search(String searchWord) {
        for (String word : magicDictionary){
            if (canMatch(searchWord , word)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */