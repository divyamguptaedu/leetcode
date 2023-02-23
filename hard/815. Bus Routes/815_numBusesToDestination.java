class Solution {
    class Pair{
        int bus;
        int temp;
        Pair (int bus, int temp) {
            this.bus = bus;
            this.temp = temp;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for( int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
               if (map.containsKey(stop) == false) {
                  map.put(stop, new ArrayList<>());
               }
               map.get(stop).add(bus);
          }
        }
            
        ArrayDeque<Pair> q = new ArrayDeque<>();
        for (int x : map.get(source)) {
            q.add(new Pair(x, 1));
        }
        boolean[] visited = new boolean[routes.length];
        while (!q.isEmpty()) {
            Pair removed = q.remove();
            if (visited[removed.bus] == true) {
                continue;
            }
            visited[removed.bus] = true;
            for (int stops: routes[removed.bus]) {
                if (stops == target) {
                    return removed.temp;
                }
            }
            for (int stop : routes[removed.bus]) {
                for (int bus : map.get(stop)) {
                    if (visited[bus] == false) {
                       q.add(new Pair(bus, removed.temp + 1));
                    }
                }
            }
        }
       
        return -1;
    }
}