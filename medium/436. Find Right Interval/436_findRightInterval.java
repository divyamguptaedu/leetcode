"""
Performance:
Runtime: 28 ms, faster than 58.19% of Java online submissions for Find Right Interval.
Memory Usage: 57.3 MB, less than 15.74% of Java online submissions for Find Right Interval.
"""

class Solution {
    private Integer helper(int[][] intervals,int num) {
        int start = 0;
        int end = intervals.length - 1;
        if (intervals[end][0] < num) {
            return null;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (num == intervals[mid][0]) {
                return num;
            }
            if (intervals[mid][0] < num) {
                start = mid + 1; 
            } else {
                end = mid - 1;
            }
        }
        return intervals[start][0];
    }
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer,Integer> valueMap = new HashMap<>();
        int i = 0;
        for (int[] interval : intervals) {
            valueMap.put(interval[0], i++);
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int result[] = new int[intervals.length];
        for (int j = 0; j < intervals.length; j++) {
            result[valueMap.get(intervals[j][0])]= valueMap.getOrDefault(helper(intervals,intervals[j][1]),-1);
        }
        return result;
    }
}