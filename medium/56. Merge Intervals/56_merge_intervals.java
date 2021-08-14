"""
Performance:
Runtime: 5 ms, faster than 94.97% of Java online submissions for Merge Intervals.
Memory Usage: 42 MB, less than 25.01% of Java online submissions for Merge Intervals.
"""

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<int[]>();
        int x = intervals[0][0];
        int y = intervals[0][1];
        // check the next's [0] and compare;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= y) {
                y = Math.max(y, intervals[i][1]);
            } else {
                result.add(new int[]{x, y});
                x = intervals[i][0];
                y = intervals[i][1];
            }
        }
        // add to result as a new array;
        result.add(new int[]{x, y});
        return result.toArray(new int[result.size()][]);
    }
}