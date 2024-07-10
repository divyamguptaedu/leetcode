// Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        if (row == 0 || col == 0) {
            return new int[]{};
        }
        
        int x = 0, y = 0;
        int[] result = new int[row * col];
        int idx = 0;
        
        while (idx < result.length) {
            result[idx++] = mat[y][x];
            
            // Determine the direction based on the sum of indices (x + y)
            if ((x + y) % 2 == 0) { // Upward direction
                if (x < col - 1 && y > 0) {
                    x++;
                    y--;
                } else if (x < col - 1) {
                    x++;
                } else {
                    y++;
                }
            } else { // Downward direction
                if (y < row - 1 && x > 0) {
                    y++;
                    x--;
                } else if (y < row - 1) {
                    y++;
                } else {
                    x++;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] matrix1 = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[] result1 = solution.findDiagonalOrder(matrix1);
        System.out.println("Diagonal order of matrix1:");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Test case 2
        int[][] matrix2 = {
            { 1, 2 },
            { 3, 4 },
            { 5, 6 }
        };
        int[] result2 = solution.findDiagonalOrder(matrix2);
        System.out.println("Diagonal order of matrix2:");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}