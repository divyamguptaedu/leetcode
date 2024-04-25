//Created the adj list, sorted each valueList for keys, ran dfs, stored the traversal in result. Returned result.
//Time: O(E log E/V) where E is the #edges and V is the vertices i.e. destinations
//Space: O(V+E)
class Solution {
    HashMap<String, LinkedList<String>> adjList = new HashMap<>();
    LinkedList<String> result = null;

    public List<String> findItinerary(List<List<String>> tickets) {
        //build adj list
        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (this.adjList.containsKey(origin)) {
                this.adjList.get(origin).add(dest);
            } else {
                LinkedList<String> destList = new LinkedList<String>();
                destList.add(dest);
                this.adjList.put(origin, destList);
            }
        }

        //sort
        this.adjList.forEach((key, value) -> Collections.sort(value));

        //dfs
        this.result = new LinkedList<String>();
        this.dfs("JFK");
        return this.result;
    }

    protected void dfs(String origin) {
        if (this.adjList.containsKey(origin)) {
            LinkedList<String> destList = this.adjList.get(origin);
            while (!destList.isEmpty()) {
                String dest = destList.pollFirst();
                dfs(dest);
            }
        }
        this.result.offerFirst(origin);
    }
}