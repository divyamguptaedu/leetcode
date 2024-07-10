import java.util.*;

class WordSearchII {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    List<String> res = new ArrayList<>();

    class Trie {
        String word;
        HashMap<Character, Trie> children;

        public Trie() {
            this.word = null;
            this.children = new HashMap<>();
        }

        public void addWord(String word) {
            Trie curr = this;
            for (char ch : word.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new Trie());
                }
                curr = curr.children.get(ch);
            }
            curr.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }

        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (trie.children.containsKey(board[i][j])) {
                    backtracking(board, i, j, trie);
                }
            }
        }
        return res;
    }

    public void backtracking(char[][] board, int i, int j, Trie node) {
        char ch = board[i][j];
        Trie curr = node.children.get(ch);
        if (curr.word != null) {
            this.res.add(curr.word);
            curr.word = null;
        }
        board[i][j] = '#';

        for (int[] dir : this.dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length)
                continue;
            if (curr.children.containsKey(board[nr][nc])) {
                backtracking(board, nr, nc, curr);
            }
        }
        board[i][j] = ch;
        if (curr.children.isEmpty()) {
            node.children.remove(ch);
        }
    }

    // Main method to test the Solution class
    public static void main(String[] args) {
        WordSearchII solution = new WordSearchII();

        // Example usage
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        List<String> result = solution.findWords(board, words);
        System.out.println("Found words: " + result);
    }
}