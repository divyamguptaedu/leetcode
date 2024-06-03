//I traversed the board cell by cell, incrementing the count whenever I encountered a 
//battleship ('X'). Then, using Depth-First Search (DFS), I marked all cells connected to 
//this battleship, horizontally or vertically, as visited. 
//This ensured that no adjacent battleships were counted multiple times. 
//I terminated DFS when reaching out-of-bounds or encountering water ('.'). 
//This approach effectively counts each distinct battleship only once.

//Time: O(mn)
//Space: O(1)
class Solution {
    int count = 0; // Initialize the count of battleships

    public int countBattleships(char[][] board) {
        int n = board.length; // Get the number of rows
        int m = board[0].length; // Get the number of columns
        // Traverse the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') { // If battleship found
                    count++; // Increment count
                    dfs(board, i, j, n, m); // Explore connected battleships
                }
            }
        }
        return count; // Return total count of battleships
    }

    public void dfs(char[][] board, int i, int j, int n, int m) {
        // Base cases for DFS termination
        if (i < 0 || j < 0 || i == n || j == m || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.'; // Mark the cell as visited
        // Explore adjacent cells
        dfs(board, i + 1, j, n, m);
        dfs(board, i, j + 1, n, m);
        dfs(board, i - 1, j, n, m);
        dfs(board, i, j - 1, n, m);
    }
}