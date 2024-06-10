//I approached the problem by iterating through the list of intervals
//and categorizing them into three steps: intervals that come before the new interval,
//intervals that overlap with the new interval,
//and intervals that come after the new interval. 
//I first added all non-overlapping intervals that end before the new interval begins, 
//then merged all overlapping intervals, and 
//finally added the remaining non-overlapping intervals. 
//This ensured that the merged intervals remained sorted and non-overlapping.

//Time: n
//Space: constant
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length; // Number of existing intervals
        int i = 0; // Index to iterate through intervals
        List<int[]> mergedIntervals = new ArrayList<>(); // Result list to store merged intervals

        // Step 1: Add all intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // Update the start and end of the new interval to include the current interval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged interval
        mergedIntervals.add(newInterval);

        // Step 3: Add all intervals that start after the new interval ends
        while (i < n) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        // Convert the result list to a 2D array and return it
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}