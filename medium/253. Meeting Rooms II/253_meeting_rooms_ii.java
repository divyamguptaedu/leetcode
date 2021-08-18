class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
        	return n;
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        queue.add(intervals[0][1]);
        
        for (int i = 1; i < n; i++) {
            if (queue.peek() <= intervals[i][0]) {
                queue.poll();
				queue.add(intervals[i][1]);
            } else {
				queue.add(intervals[i][1]);
			}
        }
        
        return queue.size();
    }
}