//We are going to use dynamic programming to solve this question. We will first initialize a grid of zeros with dimensions one greater 
//than the length of the strings to cover the base case. Once we have the grid, we will iterate each col and row starting from the last one.
//We will check if the corresponding chars for this cell are the same, if yes, we add one to its value and also use the diagonal value to 
//ensure we are not missing the count.
//If not, we take the max of the cells which are one greater in row or col.
//In the end, our answer will be in dp[0][0]

//Time: O(mn)
//Space: O(mn)
class Solution {

    public int longestCommonSubsequence(String text1, String text2) {

        // Make a grid of 0's with text2.length() + 1 columns
        // and text1.length() + 1 rows.
        int[][] dpGrid = new int[text1.length() + 1][text2.length() + 1];

        // Iterate up each column, starting from the last one.
        for (int col = text2.length() - 1; col >= 0; col--) {
            for (int row = text1.length() - 1; row >= 0; row--) {
                // If the corresponding characters for this cell are the same...
                if (text1.charAt(row) == text2.charAt(col)) {
                    dpGrid[row][col] = 1 + dpGrid[row + 1][col + 1];
                    // Otherwise they must be different...
                } else {
                    dpGrid[row][col] = Math.max(dpGrid[row + 1][col], dpGrid[row][col + 1]);
                }
            }
        }

        // The original problem's answer is in dp_grid[0][0]. Return it.
        return dpGrid[0][0];
    }
}