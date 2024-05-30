//I used a Trie (prefix tree) with a HashMap to implement the WordDictionary. 
//Each TrieNode contained a HashMap to store child nodes and a boolean to mark if the node represented the end of a word. 
//To add a word, I traversed the Trie, creating nodes as needed. 
//For searching, I recursively checked each character, handling '.' by exploring all possible child nodes at that level. 
//If I reached the end of the word and the current node marked the end of a valid word, I returned true.

//Time: O(M) for both add and search where m is the length of the key.
//Space: O(M) for add, O(1) for search.

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>(); // Map to hold child nodes
    boolean word = false; // Flag to mark if a node is the end of a word

    public TrieNode() {}
}

class WordDictionary {
    TrieNode trie; // Root node of the Trie

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new TrieNode(); // Initialize the root node
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = trie; // Start at the root

        for (char ch : word.toCharArray()) { // Traverse each character in the word
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode()); // Create a new node if it doesn't exist
            }
            node = node.children.get(ch); // Move to the next node
        }
        node.word = true; // Mark the end of the word
    }

    /** Returns if the word is in the node. */
    public boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); ++i) { // Traverse each character in the word
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                if (ch == '.') { // If character is '.', try all possible children
                    for (char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true; // Return true if any path matches
                        }
                    }
                }
                return false; // Return false if no path matches
            } else {
                node = node.children.get(ch); // Move to the next node
            }
        }
        return node.word; // Return true if the current node marks the end of a valid word
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, trie); // Start the search from the root node
    }
}