//I used a dynamic programming approach to solve the problem. 
//I initialized three arrays: `left` for the leftmost boundaries, 
//`right` for the rightmost boundaries, and `height` for the heights of '1's. 
//I iterated through each row of the matrix to update the heights, left boundaries, 
//and right boundaries. For the height, I incremented or reset based on '1' or '0'. 
//For the left and right boundaries, I adjusted based on the current positions. 
//Finally, I calculated the area for each column in the current row and 
//updated the maximum area found.

//Time: O(NM) dimensions
//Space: O(M)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n]; // initialize left as the leftmost boundary possible
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            // update left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(
                    right[j],
                    cur_right
                );
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // update area
            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }
}