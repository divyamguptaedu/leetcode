"
Performance:
Runtime: 9 ms, faster than 68.66% of Java online submissions for Employee Free Time.
Memory Usage: 40.6 MB, less than 67.33% of Java online submissions for Employee Free Time.
"

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>((i1,i2) -> Integer.compare(i1.start, i2.start));

        for (List<Interval> intervalList : schedule) {
        	for (Interval interval : intervalList) {
        		priorityQueue.add(interval);
        	}
        }        		
		List<Interval> freeIntervals = new ArrayList<>();
		
		Interval previous = null;		
		while(!priorityQueue.isEmpty()) {
            Interval current = priorityQueue.poll();
			if (previous != null && current.start > previous.end) {
				freeIntervals.add(new Interval(previous.end, current.start));
			}
            
			if (previous == null) {
				previous = current;
			}
			previous.end = Math.max(current.end, previous.end);
		}
		return freeIntervals;    
    }
}