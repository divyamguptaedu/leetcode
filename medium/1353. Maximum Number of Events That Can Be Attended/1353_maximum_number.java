"
Performance:
Runtime: 66 ms, faster than 58.70% of Java online submissions for Maximum Number of Events That Can Be Attended.
Memory Usage: 84.6 MB, less than 44.14% of Java online submissions for Maximum Number of Events That Can Be Attended.
"

class Solution {
    public int maxEvents(int[][] events) {
        int count = 0;
        int i = 0;
        Arrays.sort(events,(e1,e2) -> Integer.compare(e1[0],e2[0])); //Sort the events by the start time and in case of tie by the end time in ascending order.

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int day = 1; day <= 100000; day++) {
           while (i < events.length && events[i][0]  == day) { //adding the events starting that day
               pq.add(events[i][1]);
               i++;
           }             
           while (!pq.isEmpty() && pq.peek()<day) {//removing the events already over by that day
               pq.poll();
           }
           if (!pq.isEmpty()) {// attending the event that day and removing it
              pq.poll();
              count++;
            }
        }
        return count;
    }
}