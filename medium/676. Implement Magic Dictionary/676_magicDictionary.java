class MagicDictionary {

    Trie trie = new Trie();

    static class Trie {
        Map<Character, Trie> trieMap = new HashMap<Character, Trie>();
        boolean eow = false;

        public String toString() {
            return trieMap.toString();
        }
    }

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie tmpTrie = trie;

            for (char c : word.toCharArray()) {
                tmpTrie.trieMap.putIfAbsent(c, new Trie());
                tmpTrie = tmpTrie.trieMap.get(c);
            }
            tmpTrie.eow = true;
        }

    }

    public boolean hasOneCharacDiff(String searchWord, int index, int runDiff, Trie trie) {
        if (runDiff > 1)
            return false;

        if (index >= searchWord.length()) {
            if (runDiff == 1 && trie.eow)
                return true;
            return false;
        }

        char c = searchWord.charAt(index);
        for (char k : trie.trieMap.keySet()) {
            int addition = k == c ? 0 : 1;
            if (hasOneCharacDiff(searchWord, index + 1, runDiff + addition, trie.trieMap.get(k)))
                return true;
        }

        return false;
    }

    public boolean search(String searchWord) {
        if (hasOneCharacDiff(searchWord, 0, 0, trie))
            return true;
        return false;
    }

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */