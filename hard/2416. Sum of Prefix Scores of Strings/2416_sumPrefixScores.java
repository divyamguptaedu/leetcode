//I approached the problem of calculating prefix scores for each string in the array by using a Trie data structure. 
//Initially, I built a Trie where each node keeps track of how many times its corresponding prefix appears in the array of words. 
//During insertion of each word into the Trie, 
//I incremented counters at each node representing the prefix. 
//Then, for each word, I traversed the Trie again to compute the cumulative count of all prefixes leading up to each character of the word. 
//This count directly gives the prefix score for that word. 
//Finally, I stored these scores in an array and returned it as the result.
//Time: nl where n is num of words and l is avg len of words
//Space: nl

class TrieNode {
    final static int R = 26;

    int prefixCount;
    TrieNode[] children;

    TrieNode() {
        prefixCount = 0;
        children = new TrieNode[R];
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current.children[index].prefixCount++;
            current = current.children[index];
        }
    }

    int getPrefixCount(String word) {
        int sum = 0;
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return sum;
            }
            current = current.children[index];
            sum += current.prefixCount;
        }
        return sum;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        if (words.length == 1) {
            return new int[] { words[0].length() };
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i] = trie.getPrefixCount(words[i]);
        }
        return ans;
    }
}