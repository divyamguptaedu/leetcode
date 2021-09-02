/*
Because the maximum vertical area just depends of the width here, I don't need to consider the y-axis data. 
1. Form an array of the x-axis data and sort it.
2. Get the maxium difference.
*/

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int size = points.length;
        int array[] = new int[size];
        for (int i = 0;i < size; i++) { 
            array[i] = points[i][0];
        }
        Arrays.sort(array);
        int difference = Integer.MIN_VALUE;
        for (int i = 1; i < size; i++) {
            if ((array[i] - array[i - 1]) > difference) {
                difference = array[i] - array[i - 1];
            }
        }
        return difference;
    }
}