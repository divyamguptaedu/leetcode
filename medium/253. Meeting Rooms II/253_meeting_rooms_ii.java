//To solve this question, we can use a pq for returning the minimum value for the ending time, 
//and we can sort the given intervals array by the starting time.
//We just iterate over the itervals list, and see if a meeting is ending before a new meeting starts, if yes
//we remove the ending time from the pq, and add the new meeting's ending time instead.
//At the same time, we also update the #room by looking at the size of the meetings pq.

//Time: O(NlogN)
//Space: O(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Queue<Integer> meeting = new PriorityQueue<Integer>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int input1[], int input2[]) {
                return input1[0] - input2[0];
            }
        });

        int room = 0;
        for (int i = 0; i < intervals.length; i++) {
            while (!meeting.isEmpty() && meeting.peek() <= intervals[i][0]) { //a meeting is ending before a new one starts
                meeting.remove(); //remove an ending time
            }
            meeting.add(intervals[i][1]); //add the new ending time
            if (meeting.size() > room) { //update the size
                room = meeting.size();
            }
        }
        return room;
    }
}