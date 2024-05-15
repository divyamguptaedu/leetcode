//I sorted the intervals based on their start times. Then, I iterated through the intervals, 
//comparing the end time of the current interval with the start time of the next one. 
//If there's an overlap, I checked which interval ends later and removed the one with the later end time. 
//Incrementing the count of non-overlapping intervals, I moved to the next interval. 
//This process continues until the end of the array. 
//The logic is to minimize overlaps by selecting intervals with the earliest end times, 
//ensuring the maximum number of non-overlapping intervals.

//Time: O(nlogn) n is the length of the intervals
//Space: O(logn) space that sorting in java takes
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        if (n == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int i = 0, j = 1, nonOverlappingIntervals = 0;

        while (j < n) {
            if (intervals[i][1] > intervals[j][0]) {
                if (intervals[i][1] > intervals[j][1]) {
                    i = j;
                }
                nonOverlappingIntervals++;
            } else {
                i = j;
            }
            j++;
        }

        return nonOverlappingIntervals;
    }
}