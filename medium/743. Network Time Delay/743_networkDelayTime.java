class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        int size = times.length;
        for (int i = 0; i < size; i++) {
            adjList.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.second - y.second);
        int[] timeTaken = new int[n + 1];
        Arrays.fill(timeTaken, Integer.MAX_VALUE);
        int result = -1;
        timeTaken[k] = 0;
        pq.offer(new Pair(k, 0));
        while (!pq.isEmpty()) {
            int pqsize = pq.size();
            for (int i = 0; i < pqsize; i++) {
                Pair popped = pq.poll();
                int destination = popped.first;
                int cost = popped.second;
                for (Pair p : adjList.get(destination)) {
                    int tempNode = p.first;
                    int tempCost = p.second;
                    if (timeTaken[tempNode] > cost + tempCost) {
                        timeTaken[tempNode] = cost + tempCost;
                    }
                    pq.offer(new Pair(tempNode, cost + tempCost));
                }
            }
        }
        for (int i = 1; i < timeTaken.length; i++) {
            result = Math.max(result, timeTaken[i]);
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }
}

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

