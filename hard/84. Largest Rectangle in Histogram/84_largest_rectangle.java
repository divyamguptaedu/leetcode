"""
Performance:
Runtime: 32 ms, faster than 44.28% of Java online submissions for Largest Rectangle in Histogram.
Memory Usage: 49.8 MB, less than 44.84% of Java online submissions for Largest Rectangle in Histogram.
"""

class Solution {
    public int largestRectangleArea(int[] heights) {
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