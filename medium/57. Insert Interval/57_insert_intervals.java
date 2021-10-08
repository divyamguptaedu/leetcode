"""
Performance:
Runtime: 1 ms, faster than 99.35% of Java online submissions for Insert Interval.
Memory Usage: 41.3 MB, less than 70.32% of Java online submissions for Insert Interval.

"""

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int[] in : intervals) {         
            if (in[1] < newInterval[0]) {     
                result.add(in);
            } else if (newInterval[1] < in[0]) {
                result.add(newInterval);
                newInterval = in;
            } else {    
                newInterval[0] = Math.min(in[0], newInterval[0]);
                newInterval[1] = Math.max(in[1], newInterval[1]);
            } 

        } 
        result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }
}