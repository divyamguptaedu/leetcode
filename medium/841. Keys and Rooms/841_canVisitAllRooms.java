"
Performance:
Runtime: 4 ms, faster than 94.28% of Java online submissions for Keys and Rooms.
Memory Usage: 44.5 MB, less than 91.02% of Java online submissions for Keys and Rooms.
"

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        int count = 1;
        boolean[] flagged = new boolean[size];
        flagged[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(rooms.get(0));
        while (!queue.isEmpty()) {
            int key = queue.poll();
            if (flagged[key]) {
                continue;
            }
            queue.addAll(rooms.get(key));       
            count++;                 
            flagged[key] = true;            
        }
        return count == size;
    }
}