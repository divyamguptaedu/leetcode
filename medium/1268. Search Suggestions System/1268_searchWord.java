//To solve this question, we should use a trie. Each node would present a char and would have a list of nodes representing the children. 
//We will have to define the Trie class with the node class, the constuctor, insert method, and the retrival method.
//We can limit the retrival to 3 by using DFS.
//So, we will iterate each char of search word, traverse the trie to the node presenting the prefix, then traverse the tree from that node
//in a preorder fashion, and record whenever we get a complete word.

//Time: O(M) to build the tree where M is the total #char in products.
//Space: O(26n + m) where n is the number of nodes in the trie and m is the length of the search word.

// Custom class Trie with function to get 3 words starting with given prefix
class Trie {

    // Node definition of a trie
    class Node {
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]); //the index of an active node will tell the char it represents
    };
    Node root;
    Node curr;
    List<String> resultBuffer;

    Trie() { //initialize trie with root node
        root = new Node();
    }

    // Inserts the string in trie.
    void insert(String s) {
        // Points curr to the root of trie.
        curr = root;
        for (char c : s.toCharArray()) {
            if (curr.children.get(c - 'a') == null) { //set that char as a new node
                curr.children.set(c - 'a', new Node());
            }
            curr = curr.children.get(c - 'a');
        }

        // Mark this node as a completed word.
        curr.isWord = true; //the leaf node makes a complete word
    }

    List<String> getWordsStartingWith(String prefix) {
        curr = root;
        resultBuffer = new ArrayList<String>();
        // Move curr to the end of prefix in its trie representation.
        for (char c : prefix.toCharArray()) {
            if (curr.children.get(c - 'a') == null)
                return resultBuffer;
            curr = curr.children.get(c - 'a');
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }

    // Runs a DFS on trie starting with given prefix and adds all the words in the resultBuffer, limiting result size to 3
    void dfsWithPrefix(Node curr, String word) {
        if (resultBuffer.size() == 3)
            return;
        if (curr.isWord)
            resultBuffer.add(word);

        // Run DFS on all possible paths.
        for (char c = 'a'; c <= 'z'; c++) {
            if (curr.children.get(c - 'a') != null) {
                dfsWithPrefix(curr.children.get(c - 'a'), word + c);
            }
        }
    }
};

class Solution {
    List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        // Add all words to trie.
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }
};