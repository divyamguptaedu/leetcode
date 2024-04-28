//We create a trie (prefix tree) to make it easier for us to know what are looking for in the grid. 
//So, first we define a trieNode and also add a variable there 'word' which is set to the word which completes at that particular node.
//Once the trie is ready, we do backtracking by running a four way dfs on all the cells of the grid which are present as keys in the trie.
//In the backtracking method, we check for the positive case first, in which the trieNode we are at has a word attached to it. In that case, 
//we know that we have found the word and we add to the result list. Otherwise, we mark the cell as visited and do the 4 way dfs. 
//If not found, then we just unmark that cell.
//For optimization, we can incrementally remove the leaf noes by checking if the children of the currentNode is empty.

//For time complexity, in the worst case, we go to the end cell, i.e. O(N) and after going there we have in worst case four directions
//and three neighbors to explore, i.e 4 x 3^L-1.

//Time: O( N . 4 x 3^(L-1) )
//Space: O(N)
class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;
    public TrieNode() {}
}

class Solution {
    char[][] board = null;
    ArrayList<String> result = new ArrayList<String>();

    public List<String> findWords(char[][] board, String[] words) {
        //build the trie to save time looking for words being formed
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        this.board = board;

        //backtrack on each cell
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children.containsKey(board[row][col])) { //only if there is a word starting from that char
                    backtracking(row, col, root);
                }
            }
        }

        return this.result;
    }
    
    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this.board[row][col];
        TrieNode currNode = parent.children.get(letter);

        //check if we found a word
        if (currNode.word != null) {
            this.result.add(currNode.word);
            currNode.word = null;
        }

        //mark as visited
        this.board[row][col] = '#';

        //fire up four way dfs
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this.board.length || newCol < 0 || newCol >= this.board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this.board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }
        //set it back to original
        this.board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}
