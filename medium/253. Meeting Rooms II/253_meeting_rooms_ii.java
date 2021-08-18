"
Performance:
Runtime: 7 ms, faster than 42.19% of Java online submissions for Meeting Rooms II.
Memory Usage: 38.6 MB, less than 91.03% of Java online submissions for Meeting Rooms II.
"

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
        	return n;
        }
        
        // heap size will denote rooms occupied
        // value in each node will be meeting's end time of a room
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // add first interval's end time in heap
        queue.add(intervals[0][1]);
        
        for (int i = 1; i < n; i++) {
            // compare min end time with new interval's start time
            if (queue.peek() <= intervals[i][0]) {
                // remove min end time from heap i.e. free this room for intervals[i]
                queue.poll();
				queue.add(intervals[i][1]);
            } else {
				// occupy a new room for intervals[i]
				queue.add(intervals[i][1]);
			}
        }
        
        return queue.size();
    }
}