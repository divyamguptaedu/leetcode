//I used dynamic programming to solve this question.
//I initialized a 2D array dp to store cumulative sums. 
//In the constructor, I iterated through the given matrix and calculated the sum of 
//elements from (0,0) to (r,c) using dynamic programming. 
//Each cell dp[r+1][c+1] stores the sum of elements from (0,0) to (r,c). 
//For sumRegion, I used the cumulative sums to calculate the sum of elements 
//within the specified rectangle by subtracting appropriate cumulative sums. 
//This approach achieves O(1) time complexity for sumRegion as it performs 
//constant time operations for any rectangle.

//Time: Constructor takes O(mn), but the query takes O(1)
//Space: O(mn)
class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        
        // Initialize dp array to store cumulative sums
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        
        // Compute cumulative sums
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                // dp[r+1][c+1] stores the sum of elements from (0,0) to (r,c)
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Compute the sum of elements within the specified rectangle using cumulative sums
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}