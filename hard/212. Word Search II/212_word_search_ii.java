class Solution {
	public List<String> findWords(char[][] board, String[] words) {
	    List<String> result = new ArrayList<>();
	    TrieNode root = buildTrie(words);
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            helper (board, i, j, root, result);
	        }
	    }
	    return result;
	}

	public void helper(char[][] board, int i, int j, TrieNode p, List<String> result) {
	    char c = board[i][j];
	    if (c == '#' || p.next[c - 'a'] == null) return;
	    p = p.next[c - 'a'];
	    if (p.word != null) {   // found one
	        result.add(p.word);
	        p.word = null;     // de-duplicate
	    }

	    board[i][j] = '#';
	    if (i > 0) {
	    	helper(board, i - 1, j ,p, result); 
	    }
	    if (j > 0) {
	    	helper(board, i, j - 1, p, result);
	    }
	    if (i < board.length - 1) {
	    	helper(board, i + 1, j, p, result); 
	    }
	    if (j < board[0].length - 1) {
	    	helper(board, i, j + 1, p, result); 
	    }
	    board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
	    TrieNode root = new TrieNode();
	    for (String w : words) {
	        TrieNode p = root;
	        for (char c : w.toCharArray()) {
	            int i = c - 'a';
	            if (p.next[i] == null) p.next[i] = new TrieNode();
	            p = p.next[i];
	       }
	       p.word = w;
	    }
	    return root;
	}

	class TrieNode {
	    TrieNode[] next = new TrieNode[26];
	    String word;
	}
}