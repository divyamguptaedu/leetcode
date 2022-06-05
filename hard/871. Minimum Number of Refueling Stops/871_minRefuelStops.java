// Runtime: 5 ms, faster than 57.05% of Java online submissions for Minimum Number of Refueling Stops.
// Memory Usage: 48.9 MB, less than 44.24% of Java online submissions for Minimum Number of Refueling Stops.

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        int stops = 0;
        int station = 0;
        int fuel = startFuel;
        while (fuel < target) {
            while (station < stations.length && fuel >= stations[station][0])  {
                queue.add(stations[station][1]);
                station++;
            }
            if (queue.size() <= 0) {
                return -1;
            }
            fuel = fuel + queue.remove();
            stops++;
        }
        return stops;   
    }
}