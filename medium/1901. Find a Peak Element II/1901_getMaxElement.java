//To solve this question, we can use a binary search approach. Using binary search, we will chose the row, but in the row, finding the max element will be 
//an O(n) operation. So, we first get the mid col, then get the max element in the mid col, which means we would have already checked the top and bottom, 
//we would just need to check the left and right after getting the max element in that col. If we find a peak element, we return.
//If not, we chose the side which has the higher number.

//Time: O(nlogm) where n and m are the dimensions
//Space: O(1)
public class Solution {
        public int[] findPeakGrid(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = m - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // we find maximum because we have to check top, bottom, left, right if we use maximum then our element is definitely
            // greater than top and bottom. so we need to check only left and right i.e. our problem is reduced to find peak in 1d
            int row = getMaxElement(matrix, mid);
            int left = -1;
            int right = -1;

            if (mid - 1 >= 0) {
                left = matrix[row][mid - 1];
            }

            if (mid + 1 < m) {
                right = matrix[row][mid + 1];
            }

            // we find peak element
            if (matrix[row][mid] > left && matrix[row][mid] > right) {
                return new int[]{row, mid};
            }

            // our peak is on the left side of mid so eliminate the right part
            else if (matrix[row][mid] > right) {
                end = mid - 1;
            }

            // our peak is on the right side of mid so eliminate the left part
            else {
                start = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    // find row index of max element and col index is given by mid
    public int getMaxElement(int[][] matrix, int mid) {
        int index = -1;
        int maxi = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length; row++) {
            int elm = matrix[row][mid];

            if (elm > maxi) {
                maxi = Math.max(maxi, elm);
                index = row;
            }
        }
        return index;
    }
}