//I sorted the intervals by their start times. 
//Then, I used a linked list to store merged intervals. 
//As I iterated through the sorted intervals, 
//I checked if the current interval overlapped with the last interval in the list. 
//If there was no overlap, I added the current interval to the list. If they overlapped, 
//I merged them by updating the end of the last interval. 
//Finally, I converted the list to an array and returned it.

//Time: O(nlogn) sorting takes nlogn, otherwise its linear. Sorting dominates.
//Space: O(n)

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        
        for (int[] interval : intervals) {
            // If the list of merged intervals is empty or the current interval does not overlap with the previous
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);  // Add the current interval to the list
            }
            // If there is an overlap, merge the current and previous intervals
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        // Convert the list to an array and return it
        return merged.toArray(new int[merged.size()][]);
    }
}
