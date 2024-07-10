import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        // Priority Queue to keep track of end times of meetings
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Iterate over the sorted intervals
        for (int[] interval : intervals) {
            // If the priority queue is not empty and the earliest end time is less than or equal to the current start time
            if (!pq.isEmpty() && interval[0] >= pq.peek()) {
                pq.remove();  // Remove the room which is now free
            }

            // Add the current meeting's end time to the priority queue
            pq.add(interval[1]);
        }
        
        // The size of the priority queue tells us the minimum number of conference rooms required
        return pq.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int result1 = solution.minMeetingRooms(intervals1);
        System.out.println("Minimum number of conference rooms required (Test 1): " + result1);

        int[][] intervals2 = {{7, 10}, {2, 4}};
        int result2 = solution.minMeetingRooms(intervals2);
        System.out.println("Minimum number of conference rooms required (Test 2): " + result2);

        int[][] intervals3 = {{1, 5}, {8, 9}, {8, 9}};
        int result3 = solution.minMeetingRooms(intervals3);
        System.out.println("Minimum number of conference rooms required (Test 3): " + result3);

        int[][] intervals4 = {{1, 4}, {2, 5}, {6, 8}, {7, 9}};
        int result4 = solution.minMeetingRooms(intervals4);
        System.out.println("Minimum number of conference rooms required (Test 4): " + result4);
    }
}
