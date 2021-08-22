"
Performance:
Runtime: 4 ms, faster than 99.79% of Java online submissions for Reconstruct Itinerary.
Memory Usage: 39.5 MB, less than 75.41% of Java online submissions for Reconstruct Itinerary.
"

public class Solution {

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        helper("JFK");
        return path;
    }

    public void helper(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            helper(arrivals.poll());
        }
        path.addFirst(departure);
    }
}