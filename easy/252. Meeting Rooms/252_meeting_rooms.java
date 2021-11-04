"""
Performance:
Runtime: 4 ms, faster than 98.09% of Java online submissions for Meeting Rooms.
Memory Usage: 38.9 MB, less than 65.03% of Java online submissions for Meeting Rooms.

"""

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 1) {
            return true;  
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int[] start = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < start[1]) {
                return false;
            }
            start[1] = intervals[i][1];
        }
        return true;    
    }
}