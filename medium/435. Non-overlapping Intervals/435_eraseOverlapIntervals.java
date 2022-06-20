"""
Performance:
Runtime: 105 ms, faster than 29.22% of Java online submissions for Non-overlapping Intervals.
Memory Usage: 99.9 MB, less than 75.28% of Java online submissions for Non-overlapping Intervals.
"""

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int size = intervals.length;
        if (size == 1) {
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);
        int count = 0;
        for (int i = 1; i < size; i++) {
            int[] previous = stack.peek();
            int[] current = intervals[i];
            if (previous[1] > current[0]) {
                if(previous[1] > current[1]) {
                    stack.pop();
                    stack.add(current);
                    count++;
                    continue;
                } else {
                    count++;
                    continue;
                }
            }
            stack.add(current);
        }
        return count; 
    }
}