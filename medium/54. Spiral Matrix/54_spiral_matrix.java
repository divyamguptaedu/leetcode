class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            //Top Row
            for (int i = left ; i <= right ; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            //Right Column
            for (int i = top ; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            //Bottom Row
            if (top <= bottom) {
                for (int i = right; i >= left; i --) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            //Left Column
            if (left <= right) {
                for (int i = bottom; i >= top; i --) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}