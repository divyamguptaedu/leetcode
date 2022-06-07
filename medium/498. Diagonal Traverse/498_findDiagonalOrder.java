"
Runtime: 4 ms, faster than 54.53% of Java online submissions for Diagonal Traverse.
Memory Usage: 54.9 MB, less than 36.12% of Java online submissions for Diagonal Traverse.
"

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int size = row*col;
        int result[] = new int[size];
        int currentRow = 0;
        int currentColumn = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = mat[currentRow][currentColumn];
            if ((currentRow + currentColumn) % 2 == 0) {
                if (currentColumn == col - 1){
                    currentRow++;
                } else if (currentRow == 0) {
                    currentColumn++;
                } else {
                    currentRow--;
                    currentColumn++;
                }
            } else { 
                if (currentRow == row-1) {
                    currentColumn++;
                } else if (currentColumn == 0) {
                    currentRow++;
                } else {
                    currentColumn--;
                    currentRow++;
                }
            }
        }
        return result;
    }
}