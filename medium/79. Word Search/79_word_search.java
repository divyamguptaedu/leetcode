"""
Performance: 
Runtime: 122 ms, faster than 32.55% of Java online submissions for Word Search.
Memory Usage: 38.7 MB, less than 28.14% of Java online submissions for Word Search.
"""

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && searchletter(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    // use brute force and check adjacents;
    public boolean searchletter(int i, int j, char[][] board, String word,int position) {
        if (position == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (word.charAt(position) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '!';
        // check adjacents;
        if (searchletter(i + 1, j, board, word, position + 1)|| 
        	searchletter(i - 1, j, board, word, position + 1)||
          	searchletter(i, j + 1, board, word, position + 1)||
            searchletter(i, j - 1, board, word, position + 1)) {
        	return true;
        }
        board[i][j] = temp;
        return false;
    }
}