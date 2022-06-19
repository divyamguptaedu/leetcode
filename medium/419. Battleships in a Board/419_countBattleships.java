"
Performance:
Runtime: 2 ms, faster than 15.19% of Java online submissions for Battleships in a Board.
Memory Usage: 44.5 MB, less than 31.39% of Java online submissions for Battleships in a Board.
"

class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if (i == 0 && j == 0) {
                        result++;
                    } else if (i == 0 && board[i][j - 1] != 'X') {
                        result++;
                    } else if (j == 0 && board[i - 1][j] != 'X') {
                        result++;
                    } else if (i != 0 && j != 0 && board[i - 1][j] != 'X' && board[i][j - 1] != 'X'){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}