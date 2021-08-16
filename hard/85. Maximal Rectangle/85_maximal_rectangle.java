"""
Performance:
Runtime: 7 ms, faster than 67.31% of Java online submissions for Maximal Rectangle.
Memory Usage: 41.6 MB, less than 82.24% of Java online submissions for Maximal Rectangle.
"""

class Solution {
	public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) {
        	return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] ++;
                }
            }     
            // choosing the maximum each time;       
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
 	}

    // helper function from #84 question, to find larget area of histogram;
    private int largestRectangleArea(int[] heights) {
        int length = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= length; i++) {
            int h = (i == length ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}