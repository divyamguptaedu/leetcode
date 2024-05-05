//We can just consider the matrix as a flattened list and then just do binary search.
//Left would be 0, right would be mn-1.
//To calculate the coordinates of the point, we can just do middle value / n for the row, and middle value % n for the col.

//Time: O(log mn) where m and n are the dimensions of the matrix.
//Space: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        // binary search
        int left = 0;
        int right = m * n - 1;
        int pivotIdx;
        int pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) {
                return true;
            }
            else {
                if (target < pivotElement) {
                    right = pivotIdx - 1;
                } else {
                    left = pivotIdx + 1;
                }
            }
        }
        return false;
    }
}