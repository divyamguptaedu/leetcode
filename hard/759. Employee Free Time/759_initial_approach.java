"
Performance:
Runtime: 9 ms, faster than 68.66% of Java online submissions for Employee Free Time.
Memory Usage: 40.8 MB, less than 47.10% of Java online submissions for Employee Free Time.
"

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        List<Interval> completeIntervalList = new ArrayList<>(); 

        for (List<Interval> intervalList : schedule) {
        	for (Interval interval : intervalList) {
        		completeIntervalList.add(interval);
        	}
        }
		
		completeIntervalList.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		
		List<Interval> freeIntervalList = new ArrayList<>();
		
		Interval previous = null;		
		for (Interval interval : completeIntervalList) {
			if (previous != null && previous.end < interval.start) {
				freeIntervalList.add(new Interval(previous.end, interval.start));
			}
			if (previous == null) {
				previous = interval;
			}
			previous.end = Math.max(interval.end, previous.end);
		}
		return freeIntervalList;   
    }
}